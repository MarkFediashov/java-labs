/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team.mavenproject1;

import com.team.mavenproject1.dto.IntegralComputationDto;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author User
 */
public class SocketServerParallelIntegralExtension<T extends Function> extends ParallelIntegralExtension<T> {
    
    private final List<Address> peer = new LinkedList<>();
    private final DatagramSocket socket;
    private static final int hostProcessCount = 2;
    private Boolean isReady = false;
    
    public SocketServerParallelIntegralExtension(Integral integral) throws IOException{
        super(integral, hostProcessCount);
        socket = new DatagramSocket(Config.port);
        (new Thread(this::waitForPeers)).start();
    }
    
    private synchronized void waitForPeers(){
        while(peer.size() != hostProcessCount){
            try{
               byte[] buffer = new byte[512];
               DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
               socket.receive(packet);
               peer.add(new Address(packet.getAddress(), packet.getPort()));
            } catch (IOException exception) {
            }
        }
        Timestamp s = Timestamp.from(Instant.now());
        System.out.println(s.toString() + ": All peer connected");
        isReady = true;
        notify();
    }
    
    @Override
    public synchronized void startCompute(IntegralComputationDto dto){
        try{
            if(!isReady){
                wait();
            }
            this.tempDto = dto;
            sum = 0.0;
            final List<IntegralComputationDto> parts = this.splitForMulitpleActors(dto);
            for(int i = 0; i < peer.size(); i++){
                new Thread(new ClientActor(parts.get(i), peer.get(i))).start();
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private class ClientActor implements Runnable{
        final IntegralComputationDto dto;
        final Address client;
        
        public ClientActor(IntegralComputationDto dto, Address client){
            this.client = client;
            this.dto = dto;
        }
        
        @Override
        public void run() {
            SocketServerParallelIntegralExtension.this.proxySum(client, dto);
        }
    }
    
    private void proxySum(Address clientAddr, IntegralComputationDto dto){
        try{
            synchronized (socket) {
                final ByteArrayOutputStream arrOut = new ByteArrayOutputStream(6400);
                byte[] buffer = new byte[128];
                ObjectOutputStream out = new ObjectOutputStream(arrOut);

                out.writeObject(dto);

                final var bytes = arrOut.toByteArray();

                DatagramPacket request = new DatagramPacket(bytes, bytes.length, clientAddr.getHost(), clientAddr.getPort());

                socket.send(request);
                
                DatagramPacket response = new DatagramPacket(buffer, buffer.length);
                
                socket.receive(response);

                ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(response.getData()));
                Double result = (Double) in.readObject();
                addToIntegralSum(result);
            }
        } catch (Exception e) {
            
        } 
    }
    
}
