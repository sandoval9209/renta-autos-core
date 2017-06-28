package com.acme.repository;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.entity.Persona;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class PersonaRepositoryTest {
	
	@Autowired
	private IPersonaRepository personaDAO;

//	@Test
	public void insertPersonaTest() throws ParseException {
		Persona persona = new Persona();
		persona.setNombre("Carmen");
		persona.setApellidoP("Romero");
		persona.setSexo("Femenino");
		persona.setCelular(7771955770L);
		persona.setTelFijo(7775169012L);
		persona.setEmail("ponchito@gmail.com");
		persona.setFechanac("11/08/1972");		
		
		int id = personaDAO.insertPersona(persona);
		
		System.out.println("Id: " + id);
	}

//	@Test
	public void updatePersonaTest() throws ParseException{
		Persona persona = new Persona();
		persona.setId(1);
		persona.setApellidoP("Romero");
		persona.setCelular(7773509020L);
		persona.setEmail("labrisa@gmail.com");
		persona.setFechanac("23/08/2001");
		persona.setNombre("Brisa Gisselle");
		persona.setSexo("Femenino");
		persona.setTelFijo(5161291L);
		
		assertTrue(personaDAO.updatePersona(persona));		
	}
	
//	@Test
	public void deletePersonaTest(){
		Persona persona = new Persona();
		persona.setId(30);		
		assertTrue(personaDAO.deletePersona(persona));
	}
	
//	@Test
	public void findPersonaByIdTest(){
		Persona aux = new Persona();
		aux.setId(3);
				
		Persona persona = personaDAO.findPersonaById(aux);
		
		if(persona.getId() > 0){
			System.out.println(persona);
		}else{
			System.out.println("No se encontró ningún registro con el id "+ aux.getId());
		}			
	}
	
//	@Test
	public void findAllPersonasTest(){
		List<Persona> personas= personaDAO.findAllPersonas();
		for(Persona p: personas){
			System.out.println(p);
		}
	}
}
