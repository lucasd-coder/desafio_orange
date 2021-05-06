package com.lucas.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.desafio.entities.User;

public interface UsersRepository extends JpaRepository<User, Long>{
				
		User findByEmail(String email);
		
		User findByCpf(Integer cpf);
}
