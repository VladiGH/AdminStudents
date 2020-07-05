package com.uca.capas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.CentroEscolarDAO;
import com.uca.capas.domain.CentroEscolar;

@Service
public class CentroEscolarServiceImpl implements CentroEscolarService{

	@Autowired
	//CentroEscolarRepository ceRepository; si se usa repo
	CentroEscolarDAO ceDAO;
	
	@Override
	public List<CentroEscolar> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return ceDAO.findAll();
	}

	@Override
	@Transactional
	public void save(CentroEscolar ce) throws DataAccessException {
		// TODO Auto-generated method stub
		ceDAO.save(ce);
		/*
		 * Para guardar y editar se usa este mismo
		 * revisa si trae el id de la pk, si lo trae lo actualiza
		 * sino, crea uno nuevo
		 * */
	}

	@Override
	public CentroEscolar findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return ceDAO.findOne(code);
	}

	@Override
	@Transactional
	public void edit(CentroEscolar ce) throws DataAccessException {
		// TODO Auto-generated method stub
		ceDAO.save(ce);
	}

}
