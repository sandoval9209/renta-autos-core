package com.acme.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.entity.Persona;
import com.acme.entity.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UsuarioRepositoryTest {
	
	@Autowired
	private IUsuarioRepository usuarioDAO;

//	@Test
	public void insertUsuarioTest() {
		Usuario usuario = new Usuario("ponchito1971", "alfonsobaeza", 20);
		int id = usuarioDAO.insertUsuario(usuario);
		System.out.println("Id : " + id);
	}
	
//	@Test
	public void updateContrasenaUsuarioTest() {
		Usuario usuario = new Usuario("sandoval9209", "sandovalivan", 17);		
		assertTrue(usuarioDAO.updateContrasenaUsuario(usuario));
	}
	
//	@Test
	public void deleteUsuarioTest() {
		Usuario usuario = new Usuario("sandoval9209", "sandovalivan", 17);		
		assertTrue(usuarioDAO.deleteUsuario(usuario));
	}
	
//	@Test
	public void findUsuarioByIdTest() {
		Usuario aux = new Usuario("sandoval9209", "sandovalivan", 17);		
		Usuario usuario = usuarioDAO.findUsuarioById(aux);
		if (usuario.getIdPersona() > 0) {
			System.out.println(usuario);
		} else {
			System.out.println("No se ha encontrado registro con nombre de usuario "+ aux.getUsuario());
		}
	}
	
//	@Test
	public void findAllUsuariosTest(){
		List<Usuario> usuarios= usuarioDAO.findAllUsuarios();
		for(Usuario usuario: usuarios){
			System.out.println(usuario);
		}
	}
	
	


}
