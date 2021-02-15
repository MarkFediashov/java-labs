/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team.mavenproject1;


/**
 *
 * @author User
 */
public class ThreadSummator<T extends Function> extends Thread{
    private final ParallelIntegralExtension<T> parent;
    private final double left, rigth, dx;
    
    static Integer count = 0;
    
    public ThreadSummator(ParallelIntegralExtension<T> parent, double left, double rigth, double dx){
        super("Thread #" + count.toString());
        count++;
        this.left = left;
        this.rigth = rigth;
        this.dx = dx;
        this.parent = parent;
    }
    
    @Override
    public void run() {
        try{
            
            double val = parent.getIntegral().integrateInBounds(left, rigth, dx);
            parent.addToIntegralSum(val);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
