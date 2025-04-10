package com.github.nfdeveloper.consulta_creditos_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.nfdeveloper.consulta_creditos_api.dtos.creditos.CreditoResponseDTO;
import com.github.nfdeveloper.consulta_creditos_api.exceptions.EntidadeNaoEncontradaException;
import com.github.nfdeveloper.consulta_creditos_api.models.entitites.Credito;
import com.github.nfdeveloper.consulta_creditos_api.repositories.CreditoRepository;

@Service
public class CreditoService {

    @Autowired
    private CreditoRepository repository;
    
    public List<CreditoResponseDTO> listarPorNumeroIdentificadorNfs(String numeroNfse){
        return repository.findByNumeroNfse(numeroNfse)
                .stream()
                .map(c -> new CreditoResponseDTO(c))
                .toList();
    }

    public CreditoResponseDTO listarPorNumeroCredito(String numeroCredito){
        Credito credito = repository.findByNumeroCredito(numeroCredito).orElseThrow(() -> {
            throw new EntidadeNaoEncontradaException(String.format("Crédito de número %s não encontrado.", numeroCredito));
        });
        return new CreditoResponseDTO(credito);
    }
}
