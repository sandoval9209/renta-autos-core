package com.acme.repository;

import java.util.ArrayList;
import java.util.List;

import com.acme.entity.Automovil;

public interface IAutomovilRepository {
	public int insertAutomovil(Automovil automovil);
	public boolean updateAutomovil(Automovil automovil);
	public boolean deleteAutomovil(Automovil automovil);
	public Automovil findAutomovilById(Automovil automovil);
	public List<Automovil> findAllAutomoviles();
}
