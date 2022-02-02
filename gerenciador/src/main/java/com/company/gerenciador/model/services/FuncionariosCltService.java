package com.company.gerenciador.model.services;

import com.company.gerenciador.model.dto.FuncionariosCltDto;
import com.company.gerenciador.model.entity.FuncionariosClt;
import com.company.gerenciador.model.repositories.FuncionariosCltRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FuncionariosCltService {


    private final FuncionariosCltRepository funcionariosCLTRepository;


    public List<FuncionariosClt> findAll() {
        return funcionariosCLTRepository.findAll();
    }

    public FuncionariosCltDto findById(Long id) {
        Optional<FuncionariosClt> obj = funcionariosCLTRepository.findById(id);
        FuncionariosClt entity = obj.orElseThrow(() -> new RuntimeException("Entidade não encontrada"));

        return new FuncionariosCltDto(entity);
    }

    public void delete(Long id) {
        try {
            funcionariosCLTRepository.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Id não encontrado " + id);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Violação de integridade do banco");
        }

    }

    @Transactional //nenhuma informação será persistida se o processo não tiver 100% correto.
    public FuncionariosCltDto insert(FuncionariosCltDto dto) {

        FuncionariosClt func = new FuncionariosClt();
        func.setNome(dto.getNome());
        func.setDocumento(dto.getDocumento());
        func.setValorSalario(dto.getValorSalario());
        func = funcionariosCLTRepository.save(func);

        return new FuncionariosCltDto(func);


        //return funcionariosCLTRepository.save(func);
    }

    @Transactional
    public FuncionariosCltDto update(Long id, FuncionariosCltDto dto) {
        try {
            FuncionariosClt func = funcionariosCLTRepository.getById(id);  //busca o objeto pelo id para alterar
            func.setNome(dto.getNome());
            func.setDocumento(dto.getDocumento());
            func.setValorSalario(dto.getValorSalario());
            func = funcionariosCLTRepository.save(func);

            return new FuncionariosCltDto(func);

        } catch (EntityNotFoundException e) {
            throw new RuntimeException("Id não encontrado " + id);
        }
    }
}
