package com.acme.entity;

public class Automovil {
	
	private int id;
	private int IdPersona;
	private String descripcion;
	private String estatus;
	private String marca;			
	private int modelo;	
	private double precio;	
	
	private Persona persona;
	
	public static final String EN_RENTA = "En renta";
	public static final String DISPONIBLE = "Disponible";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdPersona() {
		return IdPersona;
	}
	public void setIdPersona(int idPersona) {
		IdPersona = idPersona;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getModelo() {
		return modelo;
	}
	public void setModelo(int modelo) {
		this.modelo = modelo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	@Override
	public String toString() {
		return "Automovil [id=" + id + ", IdPersona=" + IdPersona + ", descripcion=" + descripcion + ", estatus="
				+ estatus + ", marca=" + marca + ", modelo=" + modelo + ", precio=" + precio + ", persona=" + persona
				+ "]";
	}
	

		
}
