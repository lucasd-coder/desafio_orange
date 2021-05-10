package com.lucas.desafio.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.lucas.desafio.controllers.exceptions.FieldMessage;
import com.lucas.desafio.dto.UserDTO;
import com.lucas.desafio.entities.User;
import com.lucas.desafio.repositories.UserRepository;
import com.lucas.desafio.service.validation.utils.BR;

public class CreateUserValidation implements ConstraintValidator<CreateUser, UserDTO> {
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public void initialize(CreateUser ann) {		
	}
	
	@Override
	public boolean isValid(UserDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();				
		if (!BR.isValidCPF(objDto.getCpf())) {
			list.add(new FieldMessage("cpf", "campo CPF inválido"));
		}
		
		if(objDto.getDataDeNacimento() == null) {
			list.add(new FieldMessage("dataDeNacimento", "campo Data de nacimento obrigatório"));
		}
		
		User checkCpfExist = repository.findByCpf(objDto.getCpf());
		if(checkCpfExist != null) {
			list.add(new FieldMessage("cpf", "campo CPF já existente"));
		}
		
		User checkEmailExist = repository.findByEmail(objDto.getEmail());
		if (checkEmailExist != null) {
			list.add(new FieldMessage("email", "campo Email já existente"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
		
	}
}
