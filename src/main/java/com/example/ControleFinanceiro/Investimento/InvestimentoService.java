package com.example.ControleFinanceiro.Investimento;

import com.example.ControleFinanceiro.ContaBancaria.ContaMapper;
import com.example.ControleFinanceiro.ContaBancaria.ContaModel;
import com.example.ControleFinanceiro.ContaBancaria.ContaRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<InvestimentoModel> listarInvestimentos(){
        return investimentoRepository.findAll();
    }

    public InvestimentoModel listarInvestimentoPorId(Long id){
        return investimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Investimento não encontrado"));
    }

    public InvestimentoModel alterarInvestimento(Long id, @RequestBody InvestimentoModel investimentoAtualizado){
        InvestimentoModel investimentoExistente = investimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Investimento não encontrado"));

        // Atualiza apenas os campos necessários
        investimentoExistente.setValor(investimentoAtualizado.getValor());
        investimentoExistente.setTaxaJuros(investimentoAtualizado.getTaxaJuros());

        // salva de volta no banco
        return investimentoRepository.save(investimentoExistente);
    }

    public void deletarInvestimento(Long id){
        if(investimentoRepository.findById(id).isPresent()){
            investimentoRepository.deleteById(id);
        }
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
