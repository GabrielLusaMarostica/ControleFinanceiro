package com.example.ControleFinanceiro.Transacao;

import com.example.ControleFinanceiro.ContaBancaria.ContaModel;
import com.example.ControleFinanceiro.ContaBancaria.ContaRepository;

public class TransacaoService {
    private final ContaRepository contaRepository;
    private final TransacaoRepository transacaoRepository;

    public TransacaoService(ContaRepository contaRepository, TransacaoRepository transacaoRepository) {
        this.contaRepository = contaRepository;
        this.transacaoRepository = transacaoRepository;
    }

    public TransacaoModel criarTransacao(Long id, TransacaoModel transacaoModel){
        ContaModel conta = contaRepository.findById(id).orElseThrow(() -> new RuntimeException("Conta não encontrada"));

        transacaoModel.setConta(conta);
        conta.setSaldo(conta.getSaldo() + transacaoModel.getValor());
        contaRepository.save(conta);

        return transacaoRepository.save(transacaoModel);
    }
}
