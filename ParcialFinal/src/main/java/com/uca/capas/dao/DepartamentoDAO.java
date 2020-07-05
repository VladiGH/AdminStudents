package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Departamento;


public interface DepartamentoDAO {

	public List<Departamento> findAll() throws DataAccessException;
}
