package com.github.nfdeveloper.consulta_creditos_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.nfdeveloper.consulta_creditos_api.repositories.CreditoRepository;

@Service
public class CreditoService {

    @Autowired
    private CreditoRepository repository;
    
}
