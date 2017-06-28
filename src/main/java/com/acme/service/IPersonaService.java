package com.acme.service;

import java.util.List;

import com.acme.entity.Persona;

public interface IPersonaService {
	public int registrarPersona(Persona persona);
	public boolean actualizarInfoPersona(Persona persona);
	public boolean eliminarPersona(Persona persona);
	public Persona buscarPersonaById(Persona persona);
	public List<Persona> listaPersonas();
}
