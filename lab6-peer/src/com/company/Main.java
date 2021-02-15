package com.company;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import com.company.dto.Config;
import com.team.mavenproject1.dto.IntegralComputationDto;

public class Main {

    static final ParallelIntegralExtension<Function> integralExecutor = new ParallelIntegralExtension<>(new Integral<>(Config.fn), 2);
    static final Socket socket = new Socket();

    public static void main(String[] args) {
        try {
            socket.connect(new InetSocketAddress(Config.ip, Config.port));

            while(socket.isConnected()){
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                IntegralComputationDto dto = (IntegralComputationDto) in.readObject();
                integralExecutor.setCallback((result)-> {
                    try {
                        final ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                        out.writeObject(result);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                integralExecutor.startCompute(dto);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
