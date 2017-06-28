package com.acme.repository;

import java.util.List;

import com.acme.entity.Usuario;

public interface IUsuarioRepository {
	public int insertUsuario(Usuario usuario);
	public boolean updateContrasenaUsuario(Usuario usuario);
	public boolean deleteUsuario(Usuario usuario);
	public Usuario findUsuarioById(Usuario usuario);
	public List<Usuario> findAllUsuarios();
}
