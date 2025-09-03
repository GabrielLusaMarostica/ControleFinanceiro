package com.example.ControleFinanceiro.ContaBancaria;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContaService {

    private ContaRepository contaRepository;
    private ContaMapper contaMapper;

    public ContaService(ContaRepository contaRepository, ContaMapper contaMapper) {
        this.contaRepository = contaRepository;
        this.contaMapper = contaMapper;
    }

    public ContaDTO criarConta(ContaDTO contaDTO){
        ContaModel conta = contaMapper.map(contaDTO);
        conta = contaRepository.save(conta);
        return contaMapper.map(conta);
    }

    // listar todos os meus contas
    public List<ContaDTO> listarContas(){
        List<ContaModel> contas = contaRepository.findAll();// procura tudo que temos no ninjaRepository no meu banco de dados
        return contas.stream()
                .map(ContaMapper::map)
                .collect(Collectors.toList());
    }

    //Listar as contas por id
    public ContaDTO listarContasPorId(Long id){
        Optional<ContaModel> contaPorId = contaRepository.findById(id);
        return contaPorId.map(ContaMapper::map).orElse(null);
    }

    // Atualizar conta
    public ContaDTO atualizarConta(Long id, ContaDTO contaDTO){
        Optional<ContaModel> contaExistente = contaRepository.findById(id); // procura pelo id no banco de dados
        if(contaExistente.isPresent()){ // se o id existir
            ContaModel contaAtualizada = contaMapper.map(contaDTO); // pega o mapper do dto
            contaAtualizada.setId(id); //sobescreve o id
            ContaModel ninjaSalvo = contaRepository.save(contaAtualizada); // da um save no banco de dados com o ninja atualizado
            return contaMapper.map(ninjaSalvo); // retorna o ninja que foi salvo no banco de dados atraves do mapper
        }
        return null;
    }

    // Deletar a conta - tem que ser um metodo void, pois nao retornará nada, apenas deletará
    public void deletarContaPorId(Long id){
        contaRepository.deleteById(id);
    }

}
