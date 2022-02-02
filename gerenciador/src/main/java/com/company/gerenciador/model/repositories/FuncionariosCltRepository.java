package com.company.gerenciador.model.repositories;


import com.company.gerenciador.model.entity.FuncionariosClt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //extende as interfaces que tem no springData
public interface FuncionariosCltRepository extends JpaRepository<FuncionariosClt, Long> { //<T, ID>tipo da chave primária e a entidade


}
