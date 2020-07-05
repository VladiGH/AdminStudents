package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.UsuarioSistema;


public interface UsuarioSistemaDAO {
	public List<UsuarioSistema> findAll() throws DataAccessException;
	
	public void save(UsuarioSistema user) throws DataAccessException;
	
	public UsuarioSistema findOne(Integer code) throws DataAccessException;
}
