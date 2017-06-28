package com.acme.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

public class Persona {
	
	private int id;	
	private String nombre;	
	private String apellidoP;
	private String sexo;
	private Date fechanac;
	private long celular;	
	private long telFijo;
	private String email;
	
	private String idUsuario;
	private String contrasena;
	
	private Usuario usuario = new Usuario();
	private List<Automovil> automoviles;
	
	private final String DATE_FORMAT = "dd/MM/yyyy";
			
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
		this.usuario.setIdPersona(id);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoP() {
		return apellidoP;
	}
	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getFechanac() {
		System.out.println("get: " + fechanac.toString());
		return fechanac;
	}
	public void setFechanac(String fechanac) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		java.util.Date date = sdf.parse(fechanac); 
		this.fechanac = new java.sql.Date(date.getTime());
		System.out.println("set: " + fechanac.toString());
	}
	public long getCelular() {
		return celular;
	}
	public void setCelular(long celular) {
		this.celular = celular;
	}
	public long getTelFijo() {
		return telFijo;
	}
	public void setTelFijo(long telFijo) {
		this.telFijo = telFijo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
		
	public List<Automovil> getAutomoviles() {
		return automoviles;
	}
	public void setAutomoviles(List<Automovil> automoviles) {
		this.automoviles = automoviles;
	}
		
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
		this.usuario.setUsuario(idUsuario);
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
		this.usuario.setContrasenia(contrasena);
	}
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellidoP=" + apellidoP + ", sexo=" + sexo
				+ ", fechanac=" + fechanac + ", celular=" + celular + ", telFijo=" + telFijo + ", email=" + email + "]";
	}
		
}
