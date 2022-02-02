package com.company.gerenciador.controller;

import com.company.gerenciador.model.dto.FuncionariosCltDto;
import com.company.gerenciador.model.entity.FuncionariosClt;
import com.company.gerenciador.model.services.FuncionariosCltService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/colaboradores")
@AllArgsConstructor //criar construtores
public class ColaboradorController {

    //acessar o repositório //final garante que nenhuma alteração afetará a instância do repositório
    private final FuncionariosCltService funcionarioCltService;


    //método listar todos
    @GetMapping
    public ResponseEntity<List<FuncionariosClt>> findAll() {
        List<FuncionariosClt> list = funcionarioCltService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FuncionariosCltDto> findById(@PathVariable Long id) {

        FuncionariosCltDto func = funcionarioCltService.findById(id);

        return ResponseEntity.ok().body(func);//resposta 200 do request
    }


    @PostMapping
    public ResponseEntity<FuncionariosCltDto> insert(@RequestBody FuncionariosCltDto func) {
        func = funcionarioCltService.insert(func);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(func.getId()).toUri();//inserindo e repondendo no cabeçalho de resposta

        return ResponseEntity.created(uri).body(func);

    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        funcionarioCltService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<FuncionariosCltDto> update(@RequestBody FuncionariosCltDto func, @PathVariable Long id) {
        func = funcionarioCltService.update(id, func);
        return ResponseEntity.ok().body(func);
    }
}




