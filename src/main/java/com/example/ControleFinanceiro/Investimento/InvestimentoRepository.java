package com.example.ControleFinanceiro.Investimento;

import com.example.ControleFinanceiro.Investimento.InvestimentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestimentoRepository extends JpaRepository<InvestimentoModel, Long> {
}
