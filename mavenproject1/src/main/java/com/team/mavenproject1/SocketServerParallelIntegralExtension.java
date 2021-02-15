/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team.mavenproject1;

import com.team.mavenproject1.dto.IntegralComputationDto;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author User
 */
public class SocketServerParallelIntegralExtension<T extends Function> extends ParallelIntegralExtension<T> {
    
    private final List<Socket> peer = new LinkedList<>();
    private final ServerSocket socket;
    private static final int hostProcessCount = 1;
    private Boolean isReady = false;
    
    public SocketServerParallelIntegralExtension(Integral integral) throws IOException{
        super(integral, hostProcessCount);
        socket = new ServerSocket(Config.port);
        (new Thread(this::waitForPeers)).start();
    }
    
    private synchronized void waitForPeers(){
        while(peer.size() != hostProcessCount){
            try{
               Socket s = socket.accept();
               peer.add(s);
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
        final Socket client;
        
        public ClientActor(IntegralComputationDto dto, Socket client){
            this.client = client;
            this.dto = dto;
        }
        
        @Override
        public void run() {
            SocketServerParallelIntegralExtension.this.proxySum(client, dto);
        }
    }
    
    private void proxySum(Socket client, IntegralComputationDto dto){
        try{
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            
            out.writeObject(dto);
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());
            Double result = (Double) in.readObject();
            addToIntegralSum(result);
        } catch (Exception e) {
            
        } 
    }
    
}
