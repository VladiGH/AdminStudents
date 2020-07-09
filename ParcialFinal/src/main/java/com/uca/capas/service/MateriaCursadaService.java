package com.uca.capas.service;

import java.util.List;

import com.uca.capas.domain.Estudiante;
import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.MateriasCursadas;

public interface MateriaCursadaService {

	public List<MateriasCursadas> findAll() throws DataAccessException;
	
	public void save(MateriasCursadas materia) throws DataAccessException;

	public void edit(MateriasCursadas materia) throws DataAccessException;
	
	public MateriasCursadas findOne(Integer code) throws DataAccessException;

	public List<MateriasCursadas> findByName(Estudiante estudiante) throws DataAccessException;
}
