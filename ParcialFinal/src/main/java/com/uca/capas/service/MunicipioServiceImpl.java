package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.MunicipioDAO;
import com.uca.capas.domain.Municipio;

@Service
public class MunicipioServiceImpl implements MunicipioService {
	
	@Autowired
	//MunicipioRepo mRepository; si se usa repo
	MunicipioDAO municipioDAO;
	
	@Override
	public List<Municipio> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return municipioDAO.findAll();
	}

}
