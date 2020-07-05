package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.MateriasCursadas;

@Repository
public class MateriaCursadaDAOImpl implements MateriaCursadaDAO {
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<MateriasCursadas> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.MateriaCursada");
		Query query = entityManager.createNativeQuery(sb.toString(), MateriasCursadas.class); 
		List <MateriasCursadas> resultset = query.getResultList();
		return resultset;
	}

	@Override
	public void save(MateriasCursadas materia) throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			if(materia.getCodigoMateriaCursada()==null)
				entityManager.persist(materia);
			else {
				entityManager.merge(materia);
				entityManager.flush();
			}
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	public MateriasCursadas findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		MateriasCursadas materia = entityManager.find(MateriasCursadas.class, code);
		return materia;
	}
}
