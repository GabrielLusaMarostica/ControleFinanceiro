package com.example.ControleFinanceiro.ContaBancaria;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {

    private ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @GetMapping("/teste")
    public String teste(){
        return "Rota de teste";
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarConta(@RequestBody ContaDTO contaDTO){
        ContaDTO conta = contaService.criarConta(contaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Conta de id: " + conta.getId() + " criada com sucesso");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ContaDTO>> listarContas(){
        return ResponseEntity.ok(contaService.listarContas());
    }

    @GetMapping("/listarporid/{id}")
    public ResponseEntity<String> listarContaPorId(@PathVariable Long id){
        if(contaService.listarContasPorId(id) != null){
            return ResponseEntity.ok()
                    .body("Conta encontrado com sucesso: \n" + contaService.listarContasPorId(id));
        }
        else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("Não existe nenhuma conta com o id: " + id);
        }
    }

    @PutMapping("/alterarConta/{id}")
    public ResponseEntity<String> alterarConta(@PathVariable Long id, @RequestBody ContaDTO contaDTO){
        if(contaService.listarContasPorId(id) != null){
            ContaDTO conta = contaService.atualizarConta(id, contaDTO);
            return ResponseEntity.ok()
                    .body("A conta de nome: " + conta.getNomeDaConta() + " e id " + id + "foi encontrado com sucesso");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não existe nenhuma conta com o id: " + id);
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarConta(@PathVariable Long id){
        if(contaService.listarContasPorId(id) != null){
            contaService.deletarContaPorId(id);
            return ResponseEntity.status(HttpStatus.FOUND)
                    .body("A conta de id: " + id + " foi deletado com sucesso");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado nenhuma conta com o id: " + id);
        }
    }
}
