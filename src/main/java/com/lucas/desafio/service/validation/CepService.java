package com.lucas.desafio.service.validation;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lucas.desafio.service.validation.utils.EnderecoViaCep;

@FeignClient(url= "https://viacep.com.br/ws/" , name = "viacep")
public interface CepService {
	
	@GetMapping("{cep}/json")
	EnderecoViaCep searchEnderecoPorCep(@PathVariable("cep") String cep);

}
