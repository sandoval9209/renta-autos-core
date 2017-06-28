package com.acme.repository;

import java.util.List;
import com.acme.entity.UsuarioAdmin;

public interface IUsuarioAdminRepository {
	public int insertUsuarioAdmin(UsuarioAdmin usuario);
	public boolean updateUsuarioAdmin(UsuarioAdmin usuario);
	public boolean deleteUsuarioAdmin(UsuarioAdmin usuario);
	public UsuarioAdmin findUsuarioAdminById(UsuarioAdmin usuario);
	public List<UsuarioAdmin> findUsuariosAdmin();
}