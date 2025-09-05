package com.example.ControleFinanceiro.Investimento;

import com.example.ControleFinanceiro.ContaBancaria.ContaModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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

    @NotNull(message = "O valor do investimento é obrigatório")
    @Positive(message = "O valor deve ser maior que zero")
    @Column(name = "valor")
    private double valor;


    @NotNull(message = "A taxa de juros é obrigatória")
    @DecimalMin(value = "0.01", message = "A taxa deve ser maior que zero")
    @Column(name = "taxaJuros")
    private double taxaJuros; // ex: 0.12 para 12% ao ano

    @Column(name = "dataInicio")
    private LocalDate dataInicio;

    // @ManyToOne, uma transacao tem apenas um usuario
    @ManyToOne
    @JoinColumn(name = "conta_id") // foreing key ou chave estrangeira
    private ContaModel conta;
}
