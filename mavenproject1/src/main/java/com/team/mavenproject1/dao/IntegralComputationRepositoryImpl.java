/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team.mavenproject1.dao;

import com.team.mavenproject1.dto.IntegralComputationDto;
import com.team.mavenproject1.services.IntegralComputationDtoSerializator;
import java.util.List;


public class IntegralComputationRepositoryImpl implements IntegralComputationRepository {

    @Override
    public void saveAll(String filename, List<IntegralComputationDto> list, IntegralComputationDtoSerializator serializator) {
        serializator.saveInFile(filename, list);
    }

    @Override
    public List<IntegralComputationDto> fetchAll(String filename, IntegralComputationDtoSerializator serializator) {
        return serializator.fetchFromFile(filename);
    }
    
}
