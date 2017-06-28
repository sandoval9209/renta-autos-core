package com.acme.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.acme.entity.Usuario;
import com.acme.entity.UsuarioAdmin;
import com.acme.repository.IUsuarioAdminRepository;

@Repository
public class UsuarioAdminRepositoryImpl implements IUsuarioAdminRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	public int insertUsuarioAdmin(UsuarioAdmin usuarioAdmin) {
		String sql = "INSERT INTO usuario_admin VALUES (:id, :contrasenia, :nombre)";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(usuarioAdmin);
		int rowsAffected = namedJdbcTemplate.update(sql, parameterSource);
				
		return (rowsAffected > 0) ? usuarioAdmin.getId() : -1 ;
	}

	public boolean updateUsuarioAdmin(UsuarioAdmin usuarioAdmin) {
		String sql = "UPDATE usuario_admin SET "
				+ "contrasenia = :contrasenia, "
				+"nombre = :nombre"
				+ "WHERE id_usuario_admin = :id";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(usuarioAdmin);
		int rowsAffected = namedJdbcTemplate.update(sql, parameterSource);

		return (rowsAffected == 1) ? true : false;
	}

	public boolean deleteUsuarioAdmin(UsuarioAdmin usuarioAdmin) {
		String sql = "DELETE FROM usuario_admin WHERE id_usuario_admin = :id";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(usuarioAdmin);
		int rowsAffected = namedJdbcTemplate.update(sql, parameterSource);
		return (rowsAffected == 1) ? true : false;
	}

	public UsuarioAdmin findUsuarioAdminById(UsuarioAdmin usuarioAdmin) {
		String query = "SELECT "
				+ " id_usuario_admin, contrasenia, nombre "
				+ "FROM usuario_admin " + "WHERE id_usuario_admin = :id";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(usuarioAdmin);
		UsuarioAdmin aux = new UsuarioAdmin();
		try {
			aux = namedJdbcTemplate.queryForObject(query, parameterSource, new UsuarioAdminMapper());
		} catch (EmptyResultDataAccessException e) {
			// Do nothing here, just check the statement (Persona.getId() > 0)
			// when getting the result from this method
		}					
		return aux;
	}

	public List<UsuarioAdmin> findUsuariosAdmin() {
		String query = "SELECT "
				+ " id_usuario_admin, contrasenia, nombre "
				+ "FROM usuario_admin";	
		List<UsuarioAdmin> usuariosAdmin = new ArrayList<UsuarioAdmin>();
		try {
			usuariosAdmin = namedJdbcTemplate.query(query, new UsuarioAdminMapper());
		} catch (EmptyResultDataAccessException e) {
			// Do nothing here, just check the condition (Personas.size() > 0)
			// when getting the result from this method
		}
		return usuariosAdmin;
	}
	
	private static class UsuarioAdminMapper implements RowMapper<UsuarioAdmin> {

		public UsuarioAdmin mapRow(ResultSet rs, int rowNum) throws SQLException {
			UsuarioAdmin usuarioAdmin = new UsuarioAdmin();
			usuarioAdmin.setId(rs.getInt("id_usuario"));
			usuarioAdmin.setContrasenia(rs.getString("contrasenia"));
			usuarioAdmin.setNombre(rs.getString("nombre"));

			return usuarioAdmin;
		}
	}

}
