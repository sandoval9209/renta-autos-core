package com.acme.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acme.entity.UsuarioAdmin;
import com.acme.repository.IUsuarioAdminRepository;
import com.acme.service.IUsuarioAdminService;

@Service
public class UsuarioAdminServiceImpl implements IUsuarioAdminService {
	
	@Autowired
	private IUsuarioAdminRepository usuarioAdminDAO;

	public int registrarUsuarioAdmin(UsuarioAdmin usuarioAdmin) {
		return usuarioAdminDAO.insertUsuarioAdmin(usuarioAdmin);
	}

	public boolean actualizarUsuarioAdmin(UsuarioAdmin usuarioAdmin) {
		return usuarioAdminDAO.updateUsuarioAdmin(usuarioAdmin);
	}

	public boolean eliminarUsuarioAdmin(UsuarioAdmin usuarioAdmin) {
		return usuarioAdminDAO.deleteUsuarioAdmin(usuarioAdmin);
	}

	public UsuarioAdmin buscarUsuarioAdminById(UsuarioAdmin usuarioAdmin) {
		return usuarioAdminDAO.findUsuarioAdminById(usuarioAdmin);
	}

	public List<UsuarioAdmin> listaUsuariosAdmin() {
		return usuarioAdminDAO.findUsuariosAdmin();
	}

}
