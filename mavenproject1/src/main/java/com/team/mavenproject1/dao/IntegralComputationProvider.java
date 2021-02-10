/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team.mavenproject1.dao;

import com.team.mavenproject1.dto.IntegralComputationDto;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class IntegralComputationProvider {
    
    private final static Map<JFrame, IntegralComputationProvider> providers = new HashMap<>();
    
    private IntegralComputationProvider(){
        computationTemplateList = new LinkedList<>();
        integralComputationRepository = new IntegralComputationRepositoryImpl();
    }
    
    public static IntegralComputationProvider of(JFrame form){
        IntegralComputationProvider resolvedProvider = providers.get(form);
        if(resolvedProvider==null){
            resolvedProvider = new IntegralComputationProvider();
            providers.put(form, resolvedProvider);
        }
        
        return resolvedProvider;
    }
    
    private final List<IntegralComputationDto> computationTemplateList;
    private final IntegralComputationRepository integralComputationRepository;
    
    public IntegralComputationRepository getRepositiry(){
        return integralComputationRepository;
    }
    
    public List<IntegralComputationDto> getComputationList() {
        return computationTemplateList;
    }
}
