package com.example.ControleFinanceiro.Investimento;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/investimento")
public class InvestimentoController {
    private final InvestimentoService investimentoService;

    public InvestimentoController(InvestimentoService investimentoService) {
        this.investimentoService = investimentoService;
    }

    @PostMapping("/criar/{id}")
    public ResponseEntity<InvestimentoModel> criarInvestimento(@PathVariable Long id, InvestimentoModel investimentoModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(investimentoService.criarInvestimento(id, investimentoModel));
    }

}
