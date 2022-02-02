package com.company.gerenciador.model.dto;

import com.company.gerenciador.model.entity.FuncionariosClt;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionariosCltDto {
    private Long id;
    private String nome;
    private String documento;
    private Double valorSalario;

    public FuncionariosCltDto(FuncionariosClt entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.documento = entity.getDocumento();
        this.valorSalario = entity.getValorSalario();
    }
}
