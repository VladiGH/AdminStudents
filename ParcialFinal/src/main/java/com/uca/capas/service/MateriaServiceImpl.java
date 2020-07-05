package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.MateriaDAO;
import com.uca.capas.domain.Materia;

@Service
public class MateriaServiceImpl implements MateriaService {
	
	@Autowired
	//materiaRepo materiaRepository; si se usa repo
	MateriaDAO materiaDAO;
	
	@Override
	public List<Materia> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return materiaDAO.findAll();
	}

	@Override
	public void save(Materia materia) throws DataAccessException {
		// TODO Auto-generated method stub
		materiaDAO.save(materia);
	}

	@Override
	public Materia findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return materiaDAO.findOne(code);
	}

	@Override
	public void edit(Materia materia) throws DataAccessException {
		// TODO Auto-generated method stub
		materiaDAO.save(materia);
	}

}
