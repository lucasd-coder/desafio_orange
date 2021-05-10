package com.lucas.desafio.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.lucas.desafio.entities.Endereco;
import com.lucas.desafio.service.validation.CreateEnderecoUser;

@CreateEnderecoUser
public class EnderecoDTO implements Serializable {	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String logradouro;
	
	private Integer numero;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String complemento;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String bairro;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String cidade;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String estado;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String cep;		
	private UserDTO user;
	
	public EnderecoDTO() {		
	}
	public EnderecoDTO(Long id, String logradouro, Integer numero, String complemento, String bairro, String cidade,
			String estado, String cep, UserDTO user) {		
		this.id = id;		
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.user = user;
	}
	
	public EnderecoDTO(Endereco entity) {
		
		id = entity.getId();
		logradouro = entity.getLogradouro();
		numero = entity.getNumero();
		complemento = entity.getComplemento();
		bairro = entity.getBairro();
		cidade = entity.getCidade();
		estado = entity.getEstado();
		cep = entity.getCep();
		user = new UserDTO(entity.getUser());
	}

	 //getters e setters
	
	//}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
		

}
