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
public class RegExpTestFailedException extends ValidatorException{
    private final String doubleStr;
    
    public RegExpTestFailedException(String str){
        doubleStr = str;
    }
    
    @Override
    public String getMessage(){
        return "Regular expression test failed. String: " + doubleStr;
    }
}
