package com.acme.service;

import java.util.List;


import com.acme.entity.UsuarioAdmin;

public interface IUsuarioAdminService {
	public int registrarUsuarioAdmin(UsuarioAdmin usuario);
	public boolean actualizarUsuarioAdmin(UsuarioAdmin usuario);
	public boolean eliminarUsuarioAdmin(UsuarioAdmin usuario);
	public UsuarioAdmin buscarUsuarioAdminById(UsuarioAdmin usuario);
	public List<UsuarioAdmin> listaUsuariosAdmin();
}