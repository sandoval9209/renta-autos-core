package com.acme.service;

import java.util.List;

import com.acme.entity.Usuario;

public interface IUsuarioService {
	public int registrarUsuario(Usuario usuario);
	public boolean actualizarContrasenaUsuario(Usuario usuario);
	public boolean eliminarUsuario(Usuario usuario);
	public Usuario buscarUsuarioById(Usuario usuario);
	public List<Usuario> listaUsuarios();
}
