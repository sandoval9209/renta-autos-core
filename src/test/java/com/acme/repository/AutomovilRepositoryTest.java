package com.acme.repository;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.entity.Automovil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AutomovilRepositoryTest {
	
	@Autowired
	private IAutomovilRepository automovilDAO;	

//	@Test
	public void insertAutomovilTest() {
		Automovil automovil = new Automovil();
		automovil.setDescripcion("Automovil Chevrolet");
		automovil.setMarca("Chevy");
		automovil.setModelo(2000);
		automovil.setPrecio(50);
		
		int id = automovilDAO.insertAutomovil(automovil);
		
		System.out.println("Id: " + id);		
	}
	
//	@Test
	public void updateAutomovilTest() {
		Automovil automovil = new Automovil();
		automovil.setId(5);
		automovil.setDescripcion("Con un diseño ágil, innovación y tecnología como NissanConnect®, descubre por qué nadie querrá quedarse fuera de tu auto.");
		automovil.setMarca("Nissan March");
		automovil.setModelo(2017);
		automovil.setPrecio(200);
		
		assertTrue(automovilDAO.updateAutomovil(automovil));					
	}
	
//	@Test
	public void deleteAutomovilTest() {
		Automovil automovil = new Automovil();
		automovil.setId(0);		
		assertTrue(automovilDAO.deleteAutomovil(automovil));					
	}
	
//	@Test
	public void findAutomovilByIdTest() {
		Automovil aux = new Automovil();
		aux.setId(3);
		
		Automovil automovil = automovilDAO.findAutomovilById(aux);
		
		if(automovil.getId() > 0){
			System.out.println(automovil);
		}else{
			System.out.println("No se encontró ningún registro con el id "+ aux.getId());
		}
	}
	
	@Test
	public void findAllAutomovilesTest(){
		List<Automovil> automoviles = automovilDAO.findAllAutomoviles();
		
		for(Automovil a : automoviles){
			System.out.println(a);
		}
	}

}
