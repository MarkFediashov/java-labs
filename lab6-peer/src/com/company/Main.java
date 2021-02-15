package com.company;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

import com.company.dto.Config;
import com.team.mavenproject1.dto.IntegralComputationDto;

import javax.xml.crypto.Data;

public class Main {

    static final ParallelIntegralExtension<Function> integralExecutor = new ParallelIntegralExtension<>(new Integral<>(Config.fn), 2);
    static final byte[] inBuffer = new byte[512];
    static final byte[] outBuffer = new byte[512];

    static DatagramSocket socket;

    public static void main(String[] args) {
        try {
            final InetAddress address = InetAddress.getByName(Config.ip);
            socket = new DatagramSocket();

            DatagramPacket packet = new DatagramPacket(outBuffer, 4, address, Config.port);
            socket.send(packet);

            while(true){
                DatagramPacket input = new DatagramPacket(inBuffer, inBuffer.length);
                socket.receive(input);
                ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(input.getData()));
                IntegralComputationDto dto = (IntegralComputationDto) in.readObject();
                integralExecutor.setCallback((result)-> {
                    try {
                        ByteArrayOutputStream arrOut = new ByteArrayOutputStream(256);
                        final ObjectOutputStream out = new ObjectOutputStream(arrOut);
                        out.writeObject(result);

                        byte[] outBuffTemp = arrOut.toByteArray();

                        DatagramPacket pkt = new DatagramPacket(outBuffTemp, outBuffTemp.length, address, Config.port);
                        socket.send(pkt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                integralExecutor.startCompute(dto);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

    }
}
