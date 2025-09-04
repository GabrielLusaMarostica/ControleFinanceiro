package com.example.ControleFinanceiro.Investimento;

import com.example.ControleFinanceiro.ContaBancaria.ContaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tb_investimento")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class InvestimentoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo")
    private String tipo; // ex: "Tesouro Direto"

    @Column(name = "valor")
    private double valor;

    @Column(name = "taxaJuros")
    private double taxaJuros; // ex: 0.12 para 12% ao ano

    @Column(name = "dataInicio")
    private LocalDate dataInicio;

    // @ManyToOne, uma transacao tem apenas um usuario
    @ManyToOne
    @JoinColumn(name = "conta_id") // foreing key ou chave estrangeira
    private ContaModel conta;
}
