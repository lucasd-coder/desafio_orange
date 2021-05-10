package com.lucas.desafio.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.lucas.desafio.controllers.exceptions.FieldMessage;
import com.lucas.desafio.dto.EnderecoDTO;
import com.lucas.desafio.service.validation.utils.EnderecoViaCep;

public class CreateEnderecoUserValidation implements ConstraintValidator<CreateEnderecoUser,  EnderecoDTO> {		
	@Autowired
	private CepService searchServiceViaCep;
	
	@Override
	public void initialize(CreateEnderecoUser ann){		
	}
	
	@Override
	public boolean isValid(EnderecoDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		EnderecoViaCep searchEnderecoExist = searchServiceViaCep.searchEnderecoPorCep(objDto.getCep());
		
		if(searchEnderecoExist.getCep() == null) {
			list.add(new FieldMessage("cep", "Endereço não encontrado pela busca pelo cep" + searchEnderecoExist.getCep()));
		}
		
		if(objDto.getNumero() == null) {
			list.add(new FieldMessage("numero", "Preenchimento obrigatório"));
		}
										
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
