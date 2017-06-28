package com.acme.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acme.entity.Automovil;
import com.acme.repository.IAutomovilRepository;
import com.acme.repository.IPersonaRepository;
import com.acme.repository.IUsuarioRepository;
import com.acme.service.IAutomovilService;

@Service
public class AutomovilServiceImpl implements IAutomovilService {
	
	@Autowired
	private IAutomovilRepository automovilDAO;

	public int registrarAutomovil(Automovil automovil) {
		return automovilDAO.insertAutomovil(automovil);
	}

	public boolean actualizarInfoAutomovil(Automovil automovil) {
		return automovilDAO.updateAutomovil(automovil);
	}

	public boolean eliminarAutomovil(Automovil automovil) {
		return automovilDAO.deleteAutomovil(automovil);
	}

	public Automovil buscarAutomovilById(Automovil automovil) {
		return automovilDAO.findAutomovilById(automovil);
	}

	public List<Automovil> listaAutomoviles() {
		return automovilDAO.findAllAutomoviles();
	}

}
