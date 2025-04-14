package com.github.nfdeveloper.consulta_creditos_api.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.github.nfdeveloper.consulta_creditos_api.models.entitites.Credito;

@DataJpaTest
@ActiveProfiles("test")
public class CreditoRepositoryTest {
    
    @Autowired
    CreditoRepository repository;

    List<Credito> creditos = new ArrayList<>();

    @BeforeEach
    void setup(){
        creditos.add(new Credito(null, "123123", "456789", LocalDate.now(), new BigDecimal(12.5), "Tipo Credito", true, new BigDecimal(10.5), new BigDecimal(11.5),new BigDecimal(9.5),new BigDecimal(8.5)));
        creditos.add(new Credito(null, "123124", "456789", LocalDate.now(), new BigDecimal(12), "Tipo Credito", true, new BigDecimal(10), new BigDecimal(11),new BigDecimal(9),new BigDecimal(8)));
        creditos.add(new Credito(null, "123124", "456788", LocalDate.now(), new BigDecimal(12), "Tipo Credito", true, new BigDecimal(10), new BigDecimal(11),new BigDecimal(9),new BigDecimal(8)));

        repository.saveAll(creditos);
    }
    
    @Test
    @DisplayName("Metodo buscar por Numero do Crédito.")
    void testFindByNumeroCredito() {
        Optional<Credito> response = repository.findByNumeroCredito("123123");

        assertNotNull(response);
        assertEquals(new BigDecimal(8.5), response.get().getBaseCalculo());
    }

    @Test
    void testFindByNumeroNfse() {
        List<Credito> creditos = repository.findByNumeroNfse("456789");

        assertEquals(2, creditos.size());
    }
}
