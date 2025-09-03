package com.example.ControleFinanceiro.ContaBancaria;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
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
    private List<Transacao> transacoes = new ArrayList<>();
    private List<Investimento> investimentos = new ArrayList<>();

}
