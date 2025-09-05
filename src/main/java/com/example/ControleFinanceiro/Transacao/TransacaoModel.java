package com.example.ControleFinanceiro.Transacao;

import com.example.ControleFinanceiro.ContaBancaria.ContaModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tb_transacao")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class TransacaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @NotNull(message = "O valor do investimento é obrigatório")
    @Column(name = "valor")
    private double valor;

    @Column(name = "data")
    private LocalDate data;

    // @ManyToOne, uma transacao tem apenas um usuario
    @ManyToOne
    @JoinColumn(name = "conta_id") // foreing key ou chave estrangeira
    private ContaModel conta;
}
