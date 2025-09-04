package com.example.ControleFinanceiro.Investimento;

import com.example.ControleFinanceiro.ContaBancaria.ContaModel;
import com.example.ControleFinanceiro.ContaBancaria.ContaRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

public class InvestimentoService {
    private final InvestimentoRepository investimentoRepository;
    private final ContaRepository contaRepository;

    public InvestimentoService(InvestimentoRepository investimentoRepository, ContaRepository contaRepository) {
        this.investimentoRepository = investimentoRepository;
        this.contaRepository = contaRepository;
    }

    public InvestimentoModel criarInvestimento(Long id, @RequestBody InvestimentoModel investimentoModel){
        ContaModel conta = contaRepository.findById(id).orElseThrow(() -> new RuntimeException("Conta não encontrada"));

        investimentoModel.setConta(conta);

        return investimentoRepository.save(investimentoModel);
    }

    public String calcularInvestimentoFuturo(Long idInvestimento, int meses){
        InvestimentoModel investimento = investimentoRepository.findById(idInvestimento).orElseThrow(() -> new RuntimeException("Investimento não encontrada"));
        double saldoFuturo = investimento.getValor();
        for (int i = 0; i < meses; i++){

            saldoFuturo *= (1 + investimento.getTaxaJuros());

        }

        return "Daqui " + meses + " meses esse investimento terá R$ " + String.format("%.2f", saldoFuturo);
    }
}
