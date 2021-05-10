package com.lucas.desafio.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.desafio.dto.UserDTO;
import com.lucas.desafio.entities.User;
import com.lucas.desafio.repositories.EnderecoRepository;
import com.lucas.desafio.repositories.UserRepository;
import com.lucas.desafio.service.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public User find(Long id) {
		Optional<User> obj = repository.findById(id);		
		obj.get().setEnderecos(this.enderecoRepository.findAllByUserId(id));
		 return obj.orElseThrow(()  -> new ObjectNotFoundException(
				"User não encontrado!"));		
	}				
	public User insert(User obj) {
		obj.setId(null);
		return repository.save(obj);		
	}	
	public User froDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getNome(), objDto.getEmail(), objDto.getCpf(), objDto.getDataDeNacimento());
	}
}
