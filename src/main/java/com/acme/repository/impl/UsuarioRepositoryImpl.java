package com.acme.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.acme.entity.Persona;
import com.acme.entity.Usuario;
import com.acme.repository.IUsuarioRepository;

@Repository
public class UsuarioRepositoryImpl implements IUsuarioRepository {
	
	//@Autowired
	//private JdbcTemplate jdbcTemplate;
	//private DataSource dataSource;
	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	public int insertUsuario(Usuario usuario) {
		String sql = "INSERT INTO usuario VALUES (:usuario, :contrasenia, :idPersona)";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(usuario);
		int rowsAffected = namedJdbcTemplate.update(sql, parameterSource);
				
		return (rowsAffected > 0) ? usuario.getIdPersona() : -1 ;
	}

	public boolean updateContrasenaUsuario(Usuario usuario) {
		String sql = "UPDATE usuario SET contrasenia = :contrasenia "
				+ "WHERE usuario = :usuario";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(usuario);
		int rowsAffected = namedJdbcTemplate.update(sql, parameterSource);

		return (rowsAffected == 1) ? true : false;
	}

	public boolean deleteUsuario(Usuario usuario) {
		String sql = "DELETE FROM usuario WHERE usuario = :usuario";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(usuario);
		int rowsAffected = namedJdbcTemplate.update(sql, parameterSource);
		return (rowsAffected == 1) ? true : false;
	}

	public Usuario findUsuarioById(Usuario usuario) {
		String query = "SELECT "
				+ " usuario, contrasenia, id_persona "
				+ "FROM usuario " + "WHERE usuario = :usuario";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(usuario);
		Usuario aux = new Usuario();
		try {
			aux = namedJdbcTemplate.queryForObject(query, parameterSource, new UsuarioMapper());
		} catch (EmptyResultDataAccessException e) {
			// Do nothing here, just check the statement (Persona.getId() > 0)
			// when getting the result from this method
		}					
		return aux;
	}

	public List<Usuario> findAllUsuarios() {
		String query = "SELECT "
				+ " usuario, contrasenia, id_persona "
				+ "FROM usuario";	
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			usuarios = namedJdbcTemplate.query(query, new UsuarioMapper());
		} catch (EmptyResultDataAccessException e) {
			// Do nothing here, just check the condition (Personas.size() > 0)
			// when getting the result from this method
		}
		return usuarios;
	}
	
	private static class UsuarioMapper implements RowMapper<Usuario> {

		public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
			Usuario usuario = new Usuario();
			usuario.setUsuario(rs.getString("usuario"));
			usuario.setContrasenia(rs.getString("contrasenia"));
			usuario.setIdPersona(rs.getInt("id_persona"));

			return usuario;
		}
	}

}
