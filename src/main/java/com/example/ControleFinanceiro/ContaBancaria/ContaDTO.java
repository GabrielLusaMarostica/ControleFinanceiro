package com.example.ControleFinanceiro.ContaBancaria;

import com.example.ControleFinanceiro.Investimento.InvestimentoModel;
import com.example.ControleFinanceiro.Transacao.TransacaoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContaDTO {

    private Long id;
    private double saldo;
    private String nomeDaConta;
    private TipoConta TipoConta;
    private Long numero;
    private List<TransacaoModel> transacoes = new ArrayList<>();
    private List<InvestimentoModel> investimentos = new ArrayList<>();

}
