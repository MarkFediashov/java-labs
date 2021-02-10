/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team.mavenproject1.dto;

/**
 *
 * @author User
 */
public class IntegralComputationDto {
    
    private double left;
    private double rigth;
    private double dx;
    private double result;

    public double getLeft() {
        return left;
    }

    public void setLeft(double left) {
        this.left = left;
    }

    public double getRigth() {
        return rigth;
    }

    public void setRigth(double rigth) {
        this.rigth = rigth;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
    
    public IntegralComputationDto(){}
    
    public IntegralComputationDto(double left, double rigth, double dx, double result){
        this.left = left;
        this.rigth = rigth;
        this.dx = dx;
        this.result = result;
    }
    
    public Object[] asRow() {
        return new Object[]{
            Double.toString(left), 
            Double.toString(rigth), 
            Double.toString(dx), 
            result
        };
    }
}
