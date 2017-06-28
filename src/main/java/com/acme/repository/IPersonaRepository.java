package com.acme.repository;

import java.sql.SQLException;
import java.util.List;

import com.acme.entity.Persona;

public interface IPersonaRepository {
	
	public int insertPersona(Persona persona);
	public boolean updatePersona(Persona persona);
	public boolean deletePersona(Persona persona);
	public Persona findPersonaById(Persona persona);
	public List<Persona> findAllPersonas();

}
