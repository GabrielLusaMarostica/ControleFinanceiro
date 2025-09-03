package com.example.ControleFinanceiro.ContaBancaria;

import jakarta.persistence.*;

public enum TipoConta {
    @Column(name = "ContaCorrente")
    CORRENTE,
    @Column(name = "ContaPoupanca")
    POUPANCA,
    @Column(name = "Investimento")
    INVESTIMENTO
}
