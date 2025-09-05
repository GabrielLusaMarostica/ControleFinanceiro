package com.example.ControleFinanceiro.Transacao;

import com.example.ControleFinanceiro.Investimento.InvestimentoModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conta")

public class TransacaoController {

    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping("/criar/{id}")
    public ResponseEntity<TransacaoModel> criar(@PathVariable Long id, @RequestBody TransacaoModel transacao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(transacaoService.criarTransacao(id, transacao));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<TransacaoModel>> listarTransacoes(){
        return ResponseEntity.ok(transacaoService.listarTransacoes());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<TransacaoModel> listarTransacaoPorId(@PathVariable Long id){
        if(transacaoService.listarPorId(id) != null){
            return ResponseEntity.ok(transacaoService.listarPorId(id));
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }
}
