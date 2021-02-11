/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team.mavenproject1.services;

/**
 *
 * @author User
 */
public class Serializator {
    public static final IntegralComputationDtoSerializator json = new IntegralComputationDtoSerializatorJsonImpl();
    public static final IntegralComputationDtoSerializator bin = new IntegralComputationDtoSerializatorBinaryImpl();
    
    private Serializator(){}
}
