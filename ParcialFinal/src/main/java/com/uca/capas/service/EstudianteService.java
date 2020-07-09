package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Estudiante;

public interface EstudianteService {
	
	public List<Estudiante> findAll() throws DataAccessException;
	
	public Estudiante findOne(String code) throws DataAccessException;

	public void save(Estudiante estudiante) throws DataAccessException;
	
	public void edit(Estudiante estudiante) throws DataAccessException;

	public List<Estudiante> filterByNombre(String cadena) throws DataAccessException;

	public List<Estudiante> filterByApellido(String cadena) throws DataAccessException;

	public List<Estudiante> getByQueri(Integer tipo,String cadena) throws DataAccessException;

}
