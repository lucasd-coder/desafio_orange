package com.lucas.desafio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.desafio.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	
	List<Endereco> findAllByUserId(Long id);
				
}
