/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team.mavenproject1.validator;

import com.team.mavenproject1.exception.ArgumentTooLargeException;
import com.team.mavenproject1.exception.RegExpTestFailedException;
import com.team.mavenproject1.exception.ValidatorException;
import java.util.regex.Pattern;

/**
 *
 * @author User
 */
public class ValueValidator {
    
    private static class Bounds{
        public final static double MIN = 0.000001;
        public final static double MAX = 1000000;
        public final static String PATTERN = "[\\d]*[.]?[\\d]+";
    }
    
    public static double validateAndParse(String rawValue) throws ValidatorException{
        rawValue = rawValue.replace(',', '.');
        if(rawValue.matches(Bounds.PATTERN)){
            double value = Double.parseDouble(rawValue);
            if(value >= Bounds.MIN && value <= Bounds.MAX){
                return value;
            }
            else {
                throw new ArgumentTooLargeException(value);
            }
        }
        else {
            throw new RegExpTestFailedException(rawValue);
        }
    }
}
