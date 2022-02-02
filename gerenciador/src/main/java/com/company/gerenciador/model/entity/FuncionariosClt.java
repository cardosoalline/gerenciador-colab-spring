package com.company.gerenciador.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Data //gera getter, setter, construtor, tosrting, equals e hashcode
@Entity //especifica essa classe como uma entidade que fará mapeando com o bd
//@Table(name = "funcionariosCLT") //cria um nome diferente no bd caso queira ser != da nome da classe
@AllArgsConstructor //cria as diversas formas de construtor
@NoArgsConstructor //cria construtor vazio
public class FuncionariosClt {

    @Id //informação para o bd que é uma PK
    @GeneratedValue(strategy = GenerationType.AUTO) //para gerar o ID autoincrement
   // @JsonProperty("_id") //nomeia o atributo como vai aparecer no json (faz o papel do dto)
   //gerenciador/src/main/java/com/company/gerenciador/model/entity/FuncionariosClt.java @JsonIgnore //oculta o atributo na view (faz o papel do dto)
    private Long id;

    @Column (length = 255,nullable = false ) //identifica como uma coluna e pode identificar um nome diferente do declarado na classe ex:name = "name", pode colocar o tamanho do atributo, criar como not null
    private String nome;

    @Column (length = 15,nullable = false )
    private String documento;
    //private Endereco Endereco;

    @Column (length = 15,nullable = false )
    private Double valorSalario;
}
