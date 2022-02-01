package com.company.gerenciador.controller;

import com.company.gerenciador.model.entity.FuncionarioCLT;
import com.company.gerenciador.model.repositories.FuncionariosCLTRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/colaboradores")
@AllArgsConstructor //criar construtores
public class ColaboradorController {

    //acessar o repositório //final garante que nenhuma alteração afetará a instância do repositório
    private final FuncionariosCLTRepository funcionariosCLTRepository;



    //método listar todos
    @GetMapping
    public List<FuncionarioCLT> list(){
        return funcionariosCLTRepository.findAll();
    }


}
