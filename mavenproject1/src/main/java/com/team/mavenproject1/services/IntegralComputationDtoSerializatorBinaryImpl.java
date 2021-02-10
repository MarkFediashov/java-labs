/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team.mavenproject1.services;

import com.team.mavenproject1.dto.IntegralComputationDto;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class IntegralComputationDtoSerializatorBinaryImpl implements IntegralComputationDtoSerializator {

    @Override
    public void saveInFile(String filename, List<IntegralComputationDto> dto) {
        try{
            ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(filename));
            outStream.writeObject(dto);
        } catch (Exception e){
            System.out.println(e.getMessage());
        } 
    }

    @Override
    public List<IntegralComputationDto> fetchFromFile(String filename) {
        try{
            ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(filename));
            return (List<IntegralComputationDto>)inStream.readObject();
        } catch (Exception e) {}
        return new ArrayList<>();
    }
    
}
