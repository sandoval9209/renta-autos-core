package com.acme.entity;


public class UsuarioAdmin {
	
	private int id;
	private String nombre;
	private String contrasenia;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	@Override
	public String toString() {
		return "UsuarioAdmin [id=" + id + ", nombre=" + nombre + ", contrasenia=" + contrasenia + "]";
	}	

}
