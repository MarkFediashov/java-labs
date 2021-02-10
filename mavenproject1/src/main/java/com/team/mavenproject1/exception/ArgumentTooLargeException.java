/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team.mavenproject1.exception;

/**
 *
 * @author User
 */
public class ArgumentTooLargeException extends ValidatorException{
    private final double value;
    
    public ArgumentTooLargeException(double value){
        this.value = value;
    }
    
    @Override
    public String getMessage(){
        return "Argument must be between 0.000001 and 1000000. Argument: " + Double.toString(value);
    }
    
}
