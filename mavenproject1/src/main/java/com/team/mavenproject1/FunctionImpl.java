package com.team.mavenproject1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class FunctionImpl implements Function {

    @Override
    public double compute(double x) {
        return x*2-4;
    }
    
}
