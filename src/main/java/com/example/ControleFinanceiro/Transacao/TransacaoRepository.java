package com.example.ControleFinanceiro.Transacao;

import com.example.ControleFinanceiro.Transacao.TransacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<TransacaoModel, Long> {
}
