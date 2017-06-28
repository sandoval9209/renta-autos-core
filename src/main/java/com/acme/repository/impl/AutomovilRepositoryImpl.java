package com.acme.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.acme.entity.Automovil;
import com.acme.entity.Persona;
import com.acme.repository.IAutomovilRepository;
import com.acme.repository.IPersonaRepository;

@Repository
public class AutomovilRepositoryImpl implements IAutomovilRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	@Autowired
	private IPersonaRepository personaDAO;

	public int insertAutomovil(Automovil automovil) {
		String sql = "INSERT INTO automovil " + "(descripcion, marca, modelo, precio) "
				+ " VALUES(:descripcion, :marca, :modelo, :precio)";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(automovil);
		KeyHolder keyHolder = new GeneratedKeyHolder();

		int rowsAffected = namedJdbcTemplate.update(sql, parameterSource, keyHolder);
		return (rowsAffected == 1) ? keyHolder.getKey().intValue() : -1;		
	}

	public boolean updateAutomovil(Automovil automovil) {
		String sql = "UPDATE automovil SET " + "descripcion = :descripcion, " + "marca = :marca, " + "modelo = :modelo, "
				+ "precio = :precio "
				+ "WHERE id_automovil= :id";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(automovil);
		int rowsAffected = namedJdbcTemplate.update(sql, parameterSource);

		return (rowsAffected == 1) ? true : false;
	}

	public boolean deleteAutomovil(Automovil automovil) {
		String sql = "DELETE FROM automovil WHERE id_automovil = :id";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(automovil);
		int rowsAffected = namedJdbcTemplate.update(sql, parameterSource);
		return (rowsAffected == 1) ? true : false;
	}

	public Automovil findAutomovilById(Automovil automovil) {
		String query = "SELECT "
				+ "id_automovil, descripcion, estatus, marca, modelo, precio, id_persona "
				+ "FROM automovil " + "WHERE id_automovil = :id";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(automovil);
		Automovil aux = new Automovil();
		try {
			aux = namedJdbcTemplate.queryForObject(query, parameterSource, new AutomovilMapper());
		} catch (EmptyResultDataAccessException e) {
			// Do nothing here, just check the statement (Persona.getId() > 0) when getting the result from this method
		}
		
		if(Automovil.EN_RENTA.equalsIgnoreCase(aux.getEstatus())){
			Persona persona = new Persona();
			persona.setId(aux.getIdPersona());
			aux.setPersona(personaDAO.findPersonaById(persona));
		}		
		
		return aux;
	}

	public List<Automovil> findAllAutomoviles() {
		String query = "SELECT "
				+ "id_automovil, descripcion, estatus, marca, modelo, precio, id_persona "
				+ "FROM automovil";
		
		List<Automovil> automoviles = new ArrayList<Automovil>();
		try {
			automoviles = namedJdbcTemplate.query(query, new AutomovilMapper());
		} catch (EmptyResultDataAccessException e) {
			// Do nothing here, just check the condition (Personas.size() > 0)
			// when getting the result from this method
		}
				
		for(Automovil automovil : automoviles){
			if(Automovil.EN_RENTA.equalsIgnoreCase(automovil.getEstatus())){
				Persona persona = new Persona();
				persona.setId(automovil.getIdPersona());
				automovil.setPersona(personaDAO.findPersonaById(persona));
			}	
		}
		
		return automoviles;
	}
	
	private static class AutomovilMapper implements RowMapper<Automovil> {

		public Automovil mapRow(ResultSet rs, int rowNum) throws SQLException {
			Automovil automovil = new Automovil();
			automovil.setId(rs.getInt("id_automovil"));
			automovil.setDescripcion(rs.getString("descripcion"));
			automovil.setEstatus(rs.getString("estatus"));
			automovil.setMarca(rs.getString("marca"));
			automovil.setModelo(rs.getInt("modelo"));
			automovil.setPrecio(rs.getDouble("precio"));
			automovil.setIdPersona(rs.getInt("id_persona"));					
			
			return automovil;
		}
	}
	
}
