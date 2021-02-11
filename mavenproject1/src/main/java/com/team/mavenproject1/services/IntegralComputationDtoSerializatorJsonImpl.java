/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team.mavenproject1.services;


import com.fasterxml.jackson.core.type.TypeReference;
import com.team.mavenproject1.dto.IntegralComputationDto;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.FileOutputStream;

final class IntegralComputationDtoSerializatorJsonImpl extends BaseAbstractSerializator {
    
    final ObjectMapper mapper = new ObjectMapper();;

    @Override
    protected void saveDto(FileOutputStream file, List<IntegralComputationDto> dto) throws Exception {
        mapper.writeValue(file, dto);
    }

    @Override
    protected List<IntegralComputationDto> fetchDto(FileInputStream file) throws Exception {
        return mapper.readValue(file, new TypeReference<List<IntegralComputationDto>>() {});
    }
    
}
