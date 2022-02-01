package com.company.gerenciador.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data //gera getter, setter, construtor, tosrting, equals e hashcode
@Entity //especifica essa classe como uma entidade que fará mapeando com o bd
//@Table(name = "funcionariosCLT") //cria um nome diferente no bd caso queira ser != da nome da classe
public class FuncionarioCLT {

    @Id //informação para o bd que é uma PK
    @GeneratedValue(strategy = GenerationType.AUTO) //para gerar o ID autoincrement
    private Long id;

    @Column (length = 255,nullable = false ) //identifica como uma coluna e pode identificar um nome diferente do declarado na classe ex:name = "name", pode colocar o tamanho do atributo, criar como not null
    private String nome;

    @Column (length = 15,nullable = false )
    private String documento;
    //private Endereco Endereco;

    @Column (length = 15,nullable = false )
    private Double valorSalario;
}
