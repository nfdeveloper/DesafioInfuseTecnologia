package com.github.nfdeveloper.consulta_creditos_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.nfdeveloper.consulta_creditos_api.models.entitites.Credito;

public interface CreditoRepositories extends JpaRepository<Credito, Long>{

}
