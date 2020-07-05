package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Municipio;


public interface MunicipioDAO {
	
	public List<Municipio> findAll() throws DataAccessException;
}
