package com.acme.service;

import java.util.List;

import com.acme.entity.Automovil;

public interface IAutomovilService {
	public int registrarAutomovil(Automovil automovil);
	public boolean actualizarInfoAutomovil(Automovil automovil);
	public boolean eliminarAutomovil(Automovil automovil);
	public Automovil buscarAutomovilById(Automovil automovil);
	public List<Automovil> listaAutomoviles();
}
