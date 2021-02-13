/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team.mavenproject1;

import com.team.mavenproject1.dto.IntegralComputationDto;
import java.util.function.Consumer;
import javax.swing.SwingUtilities;

/**
 *
 * @author User
 */
public class ParallelIntegralExtension<T extends Function> {
    
    private final int threadAmount;
    private final Integral<T> syncIntegral;
    private Double sum = 0.0;
    private Consumer<Double> whenComplete;
    private IntegralComputationDto tempDto;
    int parts;
    
    
    ParallelIntegralExtension(Integral<T> integral, int threadAmount){
        this.threadAmount = threadAmount;
        syncIntegral = integral;
    }
    
    public void setCallback(Consumer<Double> callback) {
        this.whenComplete = callback;
    }
    
    public synchronized void addToIntegralSum(Double localSum) {
        sum += localSum;
        if(++parts == threadAmount){
            tempDto.setResult(sum);
            SwingUtilities.invokeLater(()->whenComplete.accept(sum));
            parts = 0;
            tempDto = null;

        }
    }
    
    public Integral<T> getIntegral (){ return syncIntegral; }
    
    private double partOf(double x, int i) { return (x / threadAmount) * i; } 
    
    public void startCompute(IntegralComputationDto dto) {
        Thread[] threads = new ThreadSummator[threadAmount];
        double length = dto.getRigth() - dto.getLeft();
        tempDto = dto;
        for(int i = 0; i < threadAmount; i++){
            threads[i] = new ThreadSummator(this, partOf(length, i), partOf(length, i + 1), dto.getDx());
        }
        sum = 0.0;
        for(int i = 0; i < threadAmount; i++){
            threads[i].start();
        }
        
    }
    
}
