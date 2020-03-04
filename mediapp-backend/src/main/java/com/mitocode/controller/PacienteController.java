package com.mitocode.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.exception.ModeloNotFoundException;
import com.mitocode.model.Paciente;
import com.mitocode.service.IPacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	private IPacienteService service;
	
	/*
	@GetMapping
	public List<Paciente> listar(){
		return service.listar();
	}
	*/
	

	@GetMapping
	public ResponseEntity<List<Paciente>> listar(){
		return new ResponseEntity<List<Paciente>>(service.listar(),HttpStatus.OK);
		//se debe poder manipular el status code de la petición
	}
	
	
	//para pasar el id lo podemos hacer por el body o por ruta
	/*@GetMapping(value = "/{id}")
	public Optional<Paciente> listarId(@PathVariable("id") Integer id){
		return service.listarId(id);
	}
	*/
	
	
	@GetMapping(value = "/{id}")
	public Optional<Paciente> listarId(@PathVariable("id") Integer id){
		Optional<Paciente> pac =  service.listarId(id);
		
		if(!pac.isPresent()) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}
		/*
		 * esto no funciono se dejo isPresent
		if(pac.get().getNombres() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}
		*/
		return pac;
	}
	
	
	//para que transforme el json en un objeto de tipo Paciente agregamos la anotacion 
	//@RequestBody
	@PostMapping 
	public Paciente registrar(@RequestBody Paciente pac) {
		return service.registrar(pac);
	}
	
	@PutMapping 
	public Paciente modificar(@RequestBody Paciente pac) {
		return service.modificar(pac);
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id){
		service.eliminar(id);
	}
	
}
