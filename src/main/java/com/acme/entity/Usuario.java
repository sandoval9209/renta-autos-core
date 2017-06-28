package com.acme.entity;

import java.util.List;

public class Usuario {
	
	private int IdPersona;
	private String usuario;	
	private String contrasenia;
	
	private Persona persona;
	
	public Usuario(){}
		
	public Usuario(String usuario, String contrasenia, int idPersona) {		
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		IdPersona = idPersona;
	}

	public int getIdPersona() {
		return IdPersona;
	}

	public void setIdPersona(int idPersona) {
		IdPersona = idPersona;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Usuario [IdPersona=" + IdPersona + ", usuario=" + usuario + ", contrasenia=" + contrasenia
				+ ", persona=" + persona + "]";
	}



}
