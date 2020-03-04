package com.mitocode.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.dao.IPacienteDAO;
import com.mitocode.model.Paciente;
import com.mitocode.service.IPacienteService;

@Service
public class PacienteServiceImpl implements IPacienteService {

	@Autowired
	private IPacienteDAO dao;
	
	@Override
	public Paciente registrar(Paciente t) {
		return dao.save(t);
	}

	@Override
	public Paciente modificar(Paciente t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<Paciente> listarId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Paciente> listar() {
		return dao.findAll(); 
	}

}
