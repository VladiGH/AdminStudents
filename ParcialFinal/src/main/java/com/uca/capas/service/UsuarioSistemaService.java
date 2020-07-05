package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.UsuarioSistema;

public interface UsuarioSistemaService {
	
	public List<UsuarioSistema> findAll() throws DataAccessException;
	
	public void save(UsuarioSistema user) throws DataAccessException;

	public void edit(UsuarioSistema user) throws DataAccessException;
	
	public UsuarioSistema findOne(Integer code) throws DataAccessException;
}
