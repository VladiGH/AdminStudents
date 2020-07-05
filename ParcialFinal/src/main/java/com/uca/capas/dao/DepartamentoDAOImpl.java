package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Departamento;


@Repository
public class DepartamentoDAOImpl implements DepartamentoDAO {

	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<Departamento> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.Departamento");
		Query query = entityManager.createNativeQuery(sb.toString(), Departamento.class); 
		List <Departamento> resultset = query.getResultList();
		return resultset;
	}
}
