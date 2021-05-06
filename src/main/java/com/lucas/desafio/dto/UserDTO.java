package com.lucas.desafio.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.lucas.desafio.entities.User;

public class UserDTO implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private LocalDate  dataDeNacimento;
	
	public UserDTO() {		
	}

	public UserDTO(Long id, String nome, String email, String cpf, LocalDate dataDeNacimento) {		
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataDeNacimento = dataDeNacimento;
	}
	
	public UserDTO(User entity) {		
		id = entity.getId();
		nome = entity.getNome();
		email = entity.getEmail();
		cpf = entity.getCpf();
		dataDeNacimento = entity.getDataDeNacimento();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataDeNacimento() {
		return dataDeNacimento;
	}

	public void setDataDeNacimento(LocalDate dataDeNacimento) {
		this.dataDeNacimento = dataDeNacimento;
	}		
	
}
