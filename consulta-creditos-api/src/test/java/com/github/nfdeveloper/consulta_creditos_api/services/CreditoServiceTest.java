package com.github.nfdeveloper.consulta_creditos_api.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.nfdeveloper.consulta_creditos_api.dtos.creditos.CreditoResponseDTO;
import com.github.nfdeveloper.consulta_creditos_api.exceptions.EntidadeNaoEncontradaException;
import com.github.nfdeveloper.consulta_creditos_api.models.entitites.Credito;
import com.github.nfdeveloper.consulta_creditos_api.repositories.CreditoRepository;

public class CreditoServiceTest {
    
    @Mock
    private CreditoRepository repository;

    @Autowired
    @InjectMocks
    private CreditoService service;

    private Credito credito;
    private List<Credito> creditos = new ArrayList<>();

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        this.credito = new Credito(1L, "123123", "456789", LocalDate.now(), new BigDecimal(12.5), "Tipo Credito", true, new BigDecimal(10.5), new BigDecimal(11.5),new BigDecimal(9.5),new BigDecimal(8.5));
        this.creditos.add(credito);
        this.creditos.add(new Credito(1L, "123124", "456789", LocalDate.now(), new BigDecimal(12), "Tipo Credito", true, new BigDecimal(10), new BigDecimal(11),new BigDecimal(9),new BigDecimal(8)));
    }

    @Test
    @DisplayName("Buscando credito por Numero do crédito com sucesso.")
    void testBuscarPorNumeroCreditoComSucesso() {
        when(repository.findByNumeroCredito(anyString())).thenReturn(Optional.of(this.credito));

        CreditoResponseDTO response = service.listarPorNumeroCredito("123123");
    
        verify(repository).findByNumeroCredito(anyString());
        assertEquals(credito.getId(), response.getId());
    }

    @Test
    @DisplayName("Buscando credito por Numero do crédito com sucesso.")
    void testBuscarPorNumeroCreditoComErro(){
        when(repository.findByNumeroCredito(anyString())).thenReturn(Optional.empty());

        assertThrows(EntidadeNaoEncontradaException.class,() -> service.listarPorNumeroCredito("1231222"));

        verify(repository).findByNumeroCredito(anyString());
    }

    @Test
    @DisplayName("Listando credito por Numero Identificador NFse")
    void testListarPorNumeroIdentificadorNfs() {
        when(repository.findByNumeroNfse(anyString())).thenReturn(this.creditos);
    
        List<CreditoResponseDTO> response = service.listarPorNumeroIdentificadorNfs("456789");

        verify(repository).findByNumeroNfse(anyString());
        assertEquals(2, response.size());
    }
}
