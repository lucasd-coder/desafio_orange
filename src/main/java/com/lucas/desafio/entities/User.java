package com.lucas.desafio.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tb_users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@Column(unique = true)
	private String email;
	
	@Column(unique = true)
	private String cpf;
	
	private LocalDate  dataDeNacimento;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Endereco> enderecos = new ArrayList<>() ;
	
	
	public User() {		
	}
	

	public User(Long id, String nome, String email, String cpf, LocalDate dataDeNacimento, List<Endereco> enderecos) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataDeNacimento = dataDeNacimento;
		this.enderecos = enderecos;
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

	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	
	
	
}
