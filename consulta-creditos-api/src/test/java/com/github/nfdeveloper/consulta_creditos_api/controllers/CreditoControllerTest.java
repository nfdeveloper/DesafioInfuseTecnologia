package com.github.nfdeveloper.consulta_creditos_api.controllers;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.github.nfdeveloper.consulta_creditos_api.dtos.creditos.CreditoResponseDTO;
import com.github.nfdeveloper.consulta_creditos_api.models.entitites.Credito;
import com.github.nfdeveloper.consulta_creditos_api.services.CreditoService;

@WebMvcTest
public class CreditoControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CreditoService creditoService;
    
    private CreditoResponseDTO creditoResponseDTO;
    private List<CreditoResponseDTO> creditosResponseDTO = new ArrayList<>();

    @BeforeEach
    void setup() {
        this.creditoResponseDTO = new CreditoResponseDTO(new Credito(1L, "123123", "456789", LocalDate.now(), new BigDecimal(12.5), "Tipo Credito", true, new BigDecimal(10.5), new BigDecimal(11.5),new BigDecimal(9.5),new BigDecimal(8.5)));

        creditosResponseDTO.add(creditoResponseDTO);
        creditosResponseDTO.add(new CreditoResponseDTO(new Credito(1L, "123123", "456789", LocalDate.now(), new BigDecimal(12.5), "Tipo Credito", true, new BigDecimal(10.5), new BigDecimal(11.5),new BigDecimal(9.5),new BigDecimal(8.5))));
    }

    @Test
    void testBuscarPorNumeroCredito() throws Exception {
        when(creditoService.listarPorNumeroCredito(anyString())).thenReturn(this.creditoResponseDTO);

        ResultActions response = mockMvc.perform(get("/api/creditos/credito/123123"));

        response.andExpect(status().isOk());
        verify(this.creditoService).listarPorNumeroCredito(anyString());
    }

    @Test
    void testListarPorNumeroIdentificadorNfs() throws Exception {
        when(creditoService.listarPorNumeroIdentificadorNfs(anyString())).thenReturn(this.creditosResponseDTO);

        ResultActions response = mockMvc.perform(get("/api/creditos/456789"));

        response.andExpect(status().isOk());
        verify(this.creditoService).listarPorNumeroIdentificadorNfs(anyString());
    }
}
