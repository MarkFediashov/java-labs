/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team.mavenproject1.services;

import com.team.mavenproject1.dto.IntegralComputationDto;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;


final class IntegralComputationDtoSerializatorBinaryImpl extends BaseAbstractSerializator {

    @Override
    protected void saveDto(FileOutputStream file, List<IntegralComputationDto> dto) throws Exception {
        ObjectOutputStream outStream = new ObjectOutputStream(file);
        outStream.writeObject(dto);
        outStream.close();
    }

    @Override
    protected List<IntegralComputationDto> fetchDto(FileInputStream file) throws Exception {
        ObjectInputStream inStream = new ObjectInputStream(file);
        var result = (List<IntegralComputationDto>)inStream.readObject();
        inStream.close();
        return result;
    }
    
}
