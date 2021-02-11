/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team.mavenproject1.services;

import com.team.mavenproject1.dto.IntegralComputationDto;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
abstract class BaseAbstractSerializator implements IntegralComputationDtoSerializator{
    
    @Override
    public void saveInFile(String filename, List<IntegralComputationDto> dto){
        FileOutputStream file;
        
        try {
            file = new FileOutputStream(filename);
            saveDto(file, dto);
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    @Override
    public List<IntegralComputationDto> fetchFromFile(String filename){
        FileInputStream file;
        
        try {
            file = new FileInputStream(filename);
            var dto = fetchDto(file);
            file.close();
            return dto;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return new ArrayList<>();
    }
    
    protected abstract void saveDto(FileOutputStream file, List<IntegralComputationDto> dto) throws Exception;
    protected abstract List<IntegralComputationDto> fetchDto(FileInputStream file) throws Exception;
}
