package com.mitocode.service;

import java.util.List;
import java.util.Optional;



/*
 *Esta interface necesita de genericos y existen varios tipos, en este caso se utiliza T, con esta
 *le estamos diciendo que necesitamos un generico de tipos, es decir que esta interface se necesita que mute de acuerdo
 *al tipo que lo necesite
 *si lo utiliza paciente se comportara como paciente
 *si lo utiliza medico se comportara como medico
 */
public interface ICRUD<T> {
	//Paciente registrar(Paciente pac)
	T registrar(T t);
	T modificar(T t);
	void eliminar(int id);
	Optional<T> listarId(int id);
	//T listId(int id);
	List<T> listar();
	//Optional<T> listarId(int id);
}
