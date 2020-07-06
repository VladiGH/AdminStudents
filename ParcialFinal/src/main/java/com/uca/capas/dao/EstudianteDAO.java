package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Estudiante;

public interface EstudianteDAO {

	public List<Estudiante> findAll() throws DataAccessException;
	
	public Estudiante findOne(String code) throws DataAccessException;
	
	public void save(Estudiante estudiante) throws DataAccessException;
	

}
