package com.example.ControleFinanceiro.Investimento;

import jdk.javadoc.doclet.Reporter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/investimento")
public class InvestimentoController {
    private final InvestimentoService investimentoService;

    public InvestimentoController(InvestimentoService investimentoService) {
        this.investimentoService = investimentoService;
    }

    @PostMapping("/criar/{id}")
    public ResponseEntity<InvestimentoModel> criarInvestimento(@PathVariable Long id, @RequestBody InvestimentoModel investimentoModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(investimentoService.criarInvestimento(id, investimentoModel));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<InvestimentoModel>> listarInvesimentos(){
        return ResponseEntity.ok()
                .body(investimentoService.listarInvestimentos());
    }

    @GetMapping("/listarPorId/{id}")
    public ResponseEntity<InvestimentoModel> listarInvestimentoPorId(@PathVariable Long id){
        if(investimentoService.listarInvestimentoPorId(id) != null){
            return ResponseEntity.ok(investimentoService.listarInvestimentoPorId(id));
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<InvestimentoModel> alterarInvestimento(@PathVariable Long id, @RequestBody InvestimentoModel investimentoModel){
        if(investimentoService.listarInvestimentoPorId(id) != null){
            investimentoService.alterarInvestimento(id, investimentoModel);
            return ResponseEntity.ok(investimentoService.listarInvestimentoPorId(id));
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarInvestimento(@PathVariable Long id){
        if(investimentoService.listarInvestimentoPorId(id) != null){
            investimentoService.deletarInvestimento(id);
            return ResponseEntity.ok("Investimento de id " + id + " foi deletado com sucesso");
        }
        else {
            return ResponseEntity.ok("Não foi encontrado nenhum investimento com este id");
        }
    }

}
