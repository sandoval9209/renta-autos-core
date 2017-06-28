package com.acme.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.acme.entity.Persona;
import com.acme.entity.Usuario;
import com.acme.repository.IPersonaRepository;
import com.acme.repository.IUsuarioRepository;
import com.acme.service.IPersonaService;
import com.acme.service.IUsuarioService;

@Service
public class PersonaServiceImpl implements IPersonaService {
	
	@Autowired
	private IPersonaRepository personaDAO;
	@Autowired
	private IUsuarioRepository usuarioDAO;

	@Transactional
	public int registrarPersona(Persona persona) {
		int idPersona = personaDAO.insertPersona(persona);
		persona.setId(idPersona);				
		usuarioDAO.insertUsuario(persona.getUsuario());
		return idPersona;
	}

	public boolean actualizarInfoPersona(Persona persona) {
		return personaDAO.updatePersona(persona);
	}

	public boolean eliminarPersona(Persona persona) {
		return personaDAO.deletePersona(persona);
	}

	public Persona buscarPersonaById(Persona persona) {
		return personaDAO.findPersonaById(persona);
	}

	public List<Persona> listaPersonas() {
		return personaDAO.findAllPersonas();
	}

}
