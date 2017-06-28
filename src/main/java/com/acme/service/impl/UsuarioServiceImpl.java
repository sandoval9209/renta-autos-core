package com.acme.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.acme.entity.Usuario;
import com.acme.repository.IUsuarioRepository;
import com.acme.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	private IUsuarioRepository usuarioDAO;

	public int registrarUsuario(Usuario usuario) {
		return usuarioDAO.insertUsuario(usuario);
	}

	public boolean actualizarContrasenaUsuario(Usuario usuario) {
		return usuarioDAO.updateContrasenaUsuario(usuario);
	}

	public boolean eliminarUsuario(Usuario usuario) {
		return usuarioDAO.deleteUsuario(usuario);
	}

	public Usuario buscarUsuarioById(Usuario usuario) {
		return usuarioDAO.findUsuarioById(usuario);
	}

	public List<Usuario> listaUsuarios() {
		return usuarioDAO.findAllUsuarios();
	}

}
