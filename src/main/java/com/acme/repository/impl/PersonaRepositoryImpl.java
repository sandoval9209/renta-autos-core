package com.acme.repository.impl;

import java.sql.Date;
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
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.acme.entity.Persona;
import com.acme.repository.IAutomovilRepository;
import com.acme.repository.IPersonaRepository;
import com.acme.repository.IUsuarioRepository;

@Repository
public class PersonaRepositoryImpl implements IPersonaRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	@Autowired
	private IUsuarioRepository usuarioDAO;
	@Autowired
	private IAutomovilRepository automovilDAO;

	public int insertPersona(Persona persona) {
		String sql = "INSERT INTO persona " + "(nombre, apellidop, sexo, celular, telfijo, email, fechanac) "
				+ " VALUES(:nombre, :apellidoP, :sexo, :celular, :telFijo, :email, :fechanac)";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(persona);
		KeyHolder keyHolder = new GeneratedKeyHolder();

		int rowsAffected = namedJdbcTemplate.update(sql, parameterSource, keyHolder);
		return (rowsAffected == 1) ? keyHolder.getKey().intValue() : -1;
	}

	public boolean updatePersona(Persona persona) {
		String sql = "UPDATE persona SET " + "apellidop = :apellidoP, " + "celular = :celular, " + "email = :email, "
				+ "fechanac = :fechanac, " + "nombre = :nombre, " + "sexo = :sexo, "
				+ "telfijo = :telFijo WHERE id_persona = :id";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(persona);
		int rowsAffected = namedJdbcTemplate.update(sql, parameterSource);

		return (rowsAffected == 1) ? true : false;
	}

	public boolean deletePersona(Persona persona) {
		String sql = "DELETE FROM persona WHERE id_persona = :id";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(persona);
		int rowsAffected = namedJdbcTemplate.update(sql, parameterSource);
		return (rowsAffected == 1) ? true : false;
	}

	public Persona findPersonaById(Persona persona) {
		String query = "SELECT "
				+ "id_persona, apellidop, celular, email, date_format(fechanac, '%d/%m/%Y') AS fechanac, nombre, sexo, telfijo "
				+ "FROM persona " + "WHERE id_persona = :id";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(persona);
		Persona aux = new Persona();
		try {
			aux = namedJdbcTemplate.queryForObject(query, parameterSource, new PersonaMapper());
		} catch (EmptyResultDataAccessException e) {
			// Do nothing here, just check the statement (Persona.getId() > 0)
			// when getting the result from this method
		}
				
		
		return aux;
	}

	public List<Persona> findAllPersonas() {
		String query = "SELECT "
				+ "id_persona, apellidop, celular, email, date_format(fechanac, '%d/%m/%Y') AS fechanac, nombre, sexo, telfijo "
				+ "FROM persona";		
		List<Persona> personas = new ArrayList<Persona>();
		try {
			personas = namedJdbcTemplate.query(query, new PersonaMapper());
		} catch (EmptyResultDataAccessException e) {
			// Do nothing here, just check the condition (Personas.size() > 0)
			// when getting the result from this method
		}
		return personas;
	}

	private static class PersonaMapper implements RowMapper<Persona> {

		public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
			Persona persona = new Persona();
			persona.setId(rs.getInt("id_persona"));
			persona.setApellidoP(rs.getString("apellidop"));
			persona.setCelular(rs.getLong("celular"));
			persona.setEmail(rs.getString("email"));
			persona.setNombre(rs.getString("nombre"));
			persona.setSexo(rs.getString("sexo"));
			persona.setTelFijo(rs.getLong("telfijo"));

			try {
				persona.setFechanac(rs.getString("fechanac"));
			} catch (ParseException e) {
				throw new SQLException("El formato de fecha es incorrecto, se esperaba dd/mm/yyyy");
			}
			// */
			return persona;
		}

	}

}
