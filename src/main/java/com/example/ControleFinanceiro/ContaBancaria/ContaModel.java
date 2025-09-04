package com.example.ControleFinanceiro.ContaBancaria;

import com.example.ControleFinanceiro.Investimento.InvestimentoModel;
import com.example.ControleFinanceiro.Transacao.TransacaoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

// Entity transforma uma classe em uma entidade do banco de dados
// JPA = Java Persistence API
@Entity
//cria o nome da tabela para o banco de dados
@Table(name = "tb_conta")
// Criacao dos contrutores com Lombok
@NoArgsConstructor
@AllArgsConstructor
//Criacao dos getters e setters com Lombok
@Data
public class ContaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "saldo")
    private double saldo;

    @Column(name = "nomeDaConta")
    private String nomeDaConta;

    @Column(name = "tipoDaConta")
    private TipoConta TipoConta;

    @Column(name = "numeroDaConta")
    private Long numero;

    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TransacaoModel> transacoes = new ArrayList<>();

    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvestimentoModel> investimentos = new ArrayList<>();
}
