package com.lucas.desafio.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lucas.desafio.dto.EnderecoDTO;
import com.lucas.desafio.entities.Endereco;
import com.lucas.desafio.service.EnderecoService;
import com.lucas.desafio.service.UsersService;

@RestController
@RequestMapping(value="/enderecos")
public class EnderecoController {
	
	@Autowired
	private EnderecoService service;
	
	@Autowired
	private UsersService usersService;
		 	
	
	@RequestMapping(value = "/{id}", method=RequestMethod.POST)
	public ResponseEntity<Endereco> insert(@Valid @RequestBody EnderecoDTO objDto, @PathVariable Long id) {
		Endereco obj = service.fromDTO(objDto);
		obj.setUser(usersService.find(id));
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				     .path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
