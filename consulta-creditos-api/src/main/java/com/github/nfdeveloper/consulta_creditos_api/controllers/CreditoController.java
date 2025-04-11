package com.github.nfdeveloper.consulta_creditos_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.nfdeveloper.consulta_creditos_api.dtos.creditos.CreditoResponseDTO;
import com.github.nfdeveloper.consulta_creditos_api.services.CreditoService;


@RestController
@RequestMapping("/api/creditos")
@CrossOrigin("http://localhost:4200")
public class CreditoController {

    @Autowired
    private CreditoService service;

    @GetMapping("/{numeroNfse}")
    public ResponseEntity<List<CreditoResponseDTO>> listarPorNumeroIdentificadorNfs(@PathVariable String numeroNfse) {
        return ResponseEntity.status(HttpStatus.OK).body(service.listarPorNumeroIdentificadorNfs(numeroNfse));
    }

    @GetMapping("/credito/{numeroCredito}")
    public ResponseEntity<CreditoResponseDTO> buscarPorNumeroCredito(@PathVariable String numeroCredito){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarPorNumeroCredito(numeroCredito));
    }
    
}
