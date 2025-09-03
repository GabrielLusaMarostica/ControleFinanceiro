package com.example.ControleFinanceiro.ContaBancaria;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_transacao")

public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // @ManyToOne, uma transacao tem apenas um usuario
    @ManyToOne
    @JoinColumn(name = "conta_id") // foreing key ou chave estrangeira
    private ContaModel conta;
}
