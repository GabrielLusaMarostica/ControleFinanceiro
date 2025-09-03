package com.example.ControleFinanceiro.ContaBancaria;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta")
public class ContaController {
    @GetMapping("/teste")
    public String teste(){
        return "Rota de teste";
    }
}
