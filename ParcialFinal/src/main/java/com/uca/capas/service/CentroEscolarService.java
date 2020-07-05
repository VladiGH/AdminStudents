package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.CentroEscolar;

public interface CentroEscolarService {
	
	public List<CentroEscolar> findAll() throws DataAccessException;
	
	public void save(CentroEscolar ce) throws DataAccessException;
	
	public void edit(CentroEscolar ce) throws DataAccessException;
	
	public CentroEscolar findOne(Integer code) throws DataAccessException;
}
