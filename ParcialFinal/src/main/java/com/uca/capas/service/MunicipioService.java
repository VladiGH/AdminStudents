package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Municipio;

public interface MunicipioService {

	public List<Municipio> findAll() throws DataAccessException;
}
