/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team.mavenproject1.dao;

import com.team.mavenproject1.dto.IntegralComputationDto;
import com.team.mavenproject1.services.IntegralComputationDtoSerializator;
import java.util.List;

/**
 *
 * @author User
 */
public interface IntegralComputationRepository {
    
    void saveAll(String filename, List<IntegralComputationDto> list, IntegralComputationDtoSerializator serializator);
    List<IntegralComputationDto> fetchAll(String filename, IntegralComputationDtoSerializator serializator);
    
}
