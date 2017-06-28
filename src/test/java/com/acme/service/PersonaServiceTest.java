package com.acme.service;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.entity.Persona;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class PersonaServiceTest {
	
	@Autowired
	private IPersonaService personaService;

	@Test
	public void registrarPersonaTest() throws ParseException {
		Persona persona = new Persona();
		persona.setNombre("Maria Jose");
		persona.setApellidoP("Romero");
		persona.setSexo("Femenino");
		persona.setCelular(7771457823L);
		persona.setTelFijo(7775166721L);
		persona.setEmail("marijose@gmail.com");
		persona.setFechanac("17/05/2009");	
		persona.setIdUsuario("marijose2009");
		persona.setContrasena("maria123");
		
		int id = personaService.registrarPersona(persona);
		
		System.out.println("Id: " + id);		
	}

}
