package com.acme.main;

import javax.sql.DataSource;

//import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.repository.IPersonaRepository;
import com.acme.repository.IUsuarioRepository;
import com.acme.repository.impl.UsuarioRepositoryImpl;

public class MainApp {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		/*
		DataSource dataSource = context.getBean("dataSource", DataSource.class);
		System.out.println("url: "+ dataSource.toString());
		//*/
		
		/*
		IUsuarioRepository usuario = context.getBean("usuarioRepositoryImpl", UsuarioRepositoryImpl.class);
		System.out.println("Usuario DAO: " + usuario);
		//*/
		
		IPersonaRepository personaDAO = context.getBean("personaRepositoryImpl", IPersonaRepository.class);
		personaDAO.insertPersona(null);
		
	}

}
