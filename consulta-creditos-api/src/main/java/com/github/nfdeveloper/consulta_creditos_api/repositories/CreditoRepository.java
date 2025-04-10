package com.github.nfdeveloper.consulta_creditos_api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.nfdeveloper.consulta_creditos_api.models.entitites.Credito;

public interface CreditoRepository extends JpaRepository<Credito, Long>{

    List<Credito> findByNumeroNfse(String numeroNfse);

    Optional<Credito> findByNumeroCredito(String numeroCredito);
}
