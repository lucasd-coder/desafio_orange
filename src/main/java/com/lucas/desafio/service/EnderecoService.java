package com.lucas.desafio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.desafio.dto.EnderecoDTO;
import com.lucas.desafio.entities.Endereco;
import com.lucas.desafio.repositories.EnderecoRepository;

@Service
public class EnderecoService {
		
	@Autowired
	private EnderecoRepository repository;				
	public Endereco insert(Endereco obj) {
		obj.setId(null);		
		obj = repository.save(obj);
		
		return obj;		
	}	
	public Endereco fromDTO(EnderecoDTO objDto) {
		return new Endereco(objDto.getId(), objDto.getLogradouro(), objDto.getNumero(), 
				objDto.getComplemento(), objDto.getBairro(), 
				objDto.getCidade(),objDto.getEstado(), objDto.getCep(), null );
	}
}
