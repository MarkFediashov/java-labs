package com.team.mavenproject1;

import com.team.mavenproject1.dto.IntegralComputationDto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Integral<T extends Function> {
    private final T function;
    
    Integral(T function){
        this.function = function;
    }
    
    public double integrateInBounds(double left, double rigth, double dx){
        double start = left;
        double sum = 0.0;
        double currentRigth = Math.min(left + dx, rigth);
        
        while(true){
            double tempSum = ((function.compute(left) + function.compute(currentRigth)) * 0.5) * dx;
            sum += tempSum;
            System.out.println(String.format("Temp %f to %f by %f = %f; total = %f", left, currentRigth, dx, tempSum, sum));
            if(currentRigth >= rigth){
                break;
            }
            left += dx;
            currentRigth = Math.min(currentRigth + dx, rigth);
        }
        
        System.out.println(String.format("From %f to %f by %f = %f", start, rigth, dx, sum));
        
        return sum;
    }
    
    public void computeIntegralDto(IntegralComputationDto dto){
        dto.setResult(integrateInBounds(dto.getLeft(), dto.getRigth(), dto.getDx()));
    }
    
    public T getFunction(){
        return function;
    }
}
