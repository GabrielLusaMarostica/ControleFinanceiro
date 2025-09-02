package com.example.ControleFinanceiro.ContaBancaria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<ContaModel, Long> {
}
