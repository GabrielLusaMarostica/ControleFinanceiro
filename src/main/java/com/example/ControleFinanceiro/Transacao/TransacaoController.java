package com.example.ControleFinanceiro.Transacao;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conta")

public class TransacaoController {

    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping("/criar/{contaId}")
    public ResponseEntity<TransacaoModel> criar(@PathVariable Long contaId, @RequestBody TransacaoModel transacao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(transacaoService.criarTransacao(contaId, transacao));
    }
}
