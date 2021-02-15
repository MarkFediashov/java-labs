/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;


import com.team.mavenproject1.dto.IntegralComputationDto;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author User
 */
public class ParallelIntegralExtension<T extends Function> {

    protected final int threadAmount;
    private final Integral<T> syncIntegral;
    private Double sum = 0.0;
    private Consumer<Double> whenComplete;
    protected IntegralComputationDto tempDto;
    int parts;


    ParallelIntegralExtension(Integral<T> integral, int threadAmount){
        this.threadAmount = threadAmount;
        syncIntegral = integral;
    }

    public void setCallback(Consumer<Double> callback) {
        this.whenComplete = callback;
    }

    final public synchronized void addToIntegralSum(Double localSum) {
        sum += localSum;
        if(++parts == threadAmount){
            tempDto.setResult(sum);
            whenComplete.accept(sum);
            parts = 0;
            tempDto = null;

        }
    }

    public Integral<T> getIntegral (){ return syncIntegral; }

    protected double partOf(double x, int i) { return (x / threadAmount) * i; }

    protected List<IntegralComputationDto> splitForMulitpleActors (IntegralComputationDto dto){
        List<IntegralComputationDto> list = new ArrayList<>(threadAmount);
        double length = dto.getRigth() - dto.getLeft();
        for(int i = 0; i < threadAmount; i++) {
            list.add(new IntegralComputationDto(dto.getLeft() + partOf(length, i),dto.getLeft() + partOf(length, i + 1), dto.getDx(), 0.0));
        }
        return list;
    }

    public void startCompute(IntegralComputationDto dto) {

        tempDto = dto;
        sum = 0.0;

        for(IntegralComputationDto part: splitForMulitpleActors(dto)){
            new ThreadSummator<>(this,part.getLeft(), part.getRigth(), part.getDx()).start();
        }

    }
    
}
