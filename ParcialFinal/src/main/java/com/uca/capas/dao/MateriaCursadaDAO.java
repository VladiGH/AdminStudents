package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.MateriasCursadas;

public interface MateriaCursadaDAO {
	public List<MateriasCursadas> findAll() throws DataAccessException;
	
	public void save(MateriasCursadas materia) throws DataAccessException;
	
	public MateriasCursadas findOne(Integer code) throws DataAccessException;
}
