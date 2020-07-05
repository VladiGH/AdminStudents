package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Materia;

public interface MateriaService {
	
	public List<Materia> findAll() throws DataAccessException;
	
	public void save(Materia materia) throws DataAccessException;

	public void edit(Materia materia) throws DataAccessException;
	
	public Materia findOne(Integer code) throws DataAccessException;
}
