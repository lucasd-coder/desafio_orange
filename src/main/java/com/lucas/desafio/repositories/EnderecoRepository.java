package com.lucas.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.desafio.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	
	Endereco findByCep(String cep);
			
}
