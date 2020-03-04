package com.mitocode.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Paciente;

//debemos de extender la interface con JPARepository
public interface IPacienteDAO extends JpaRepository<Paciente, Integer> {
	
}
