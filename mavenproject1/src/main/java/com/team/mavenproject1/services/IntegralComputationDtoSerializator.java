/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team.mavenproject1.services;

import com.team.mavenproject1.dto.IntegralComputationDto;
import java.util.List;

/**
 *
 * @author User
 */
public interface IntegralComputationDtoSerializator {
    void saveInFile(String filename, List<IntegralComputationDto> dto);
    List<IntegralComputationDto> fetchFromFile(String filename);
}
