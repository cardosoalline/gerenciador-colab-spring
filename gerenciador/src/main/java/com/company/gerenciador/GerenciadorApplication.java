package com.company.gerenciador;

import com.company.gerenciador.model.entity.FuncionarioCLT;
import com.company.gerenciador.model.repositories.FuncionariosCLTRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GerenciadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(FuncionariosCLTRepository funcionariosCLTRepository) {
		return args -> {
			funcionariosCLTRepository.deleteAll();


			FuncionarioCLT f = new FuncionarioCLT();
			f.setNome("teste");
			f.setDocumento("1212");
			f.setValorSalario(120.0);
			funcionariosCLTRepository.save(f);
		};
	}
	}
