package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Materia;

@Repository
public class MateriaDAOImpl implements MateriaDAO{

	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<Materia> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.Materia");
		Query query = entityManager.createNativeQuery(sb.toString(), Materia.class); 
		List <Materia> resultset = query.getResultList();
		return resultset;
	}

	@Override
	public void save(Materia materia) throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			if(materia.getCodigoMateria()==null)
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
	public Materia findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		Materia materia = entityManager.find(Materia.class, code);
		return materia;
	}

}
