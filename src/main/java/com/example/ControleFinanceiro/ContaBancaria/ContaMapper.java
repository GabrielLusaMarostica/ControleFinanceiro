package com.example.ControleFinanceiro.ContaBancaria;

import org.springframework.stereotype.Component;

@Component
public class ContaMapper {
    public ContaModel map(ContaDTO contaDTO){
        ContaModel contaModel = new ContaModel();
        contaModel.setId(contaDTO.getId());
        contaModel.setNomeDaConta(contaDTO.getNomeDaConta());
        contaModel.setTipoConta(contaDTO.getTipoConta());
        contaModel.setSaldo(contaDTO.getSaldo());
        contaModel.setNumero(contaDTO.getNumero());
        contaModel.setInvestimentos(contaDTO.getInvestimentos());
        contaModel.setTransacoes(contaDTO.getTransacoes());

        return contaModel;
    }

    public static ContaDTO map(ContaModel contaModel){
        ContaDTO contaDTO = new ContaDTO();
        contaDTO.setId(contaModel.getId());
        contaDTO.setNomeDaConta(contaModel.getNomeDaConta());
        contaDTO.setTipoConta(contaModel.getTipoConta());
        contaDTO.setSaldo(contaModel.getSaldo());
        contaDTO.setNumero(contaModel.getNumero());
        contaDTO.setInvestimentos(contaModel.getInvestimentos());
        contaDTO.setTransacoes(contaModel.getTransacoes());

        return contaDTO;
    }

}
