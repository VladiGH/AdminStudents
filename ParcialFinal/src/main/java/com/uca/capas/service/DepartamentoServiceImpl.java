package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.DepartamentoDAO;
import com.uca.capas.domain.Departamento;

@Service
public class DepartamentoServiceImpl implements DepartamentoService{

	@Autowired
	//DepartamentoRepo depaRepository; si se usa repo
	DepartamentoDAO depaDAO;
	
	@Override
	public List<Departamento> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return depaDAO.findAll();
	}

}
