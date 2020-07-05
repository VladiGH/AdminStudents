package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.CentroEscolar;

@Repository
public class CentroEscolarDAOImpl implements CentroEscolarDAO{

	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<CentroEscolar> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.CentroEscolar");
		Query query = entityManager.createNativeQuery(sb.toString(), CentroEscolar.class); 
		List <CentroEscolar> resultset = query.getResultList();
		return resultset;
	}

	@Override
	public void save(CentroEscolar ce) throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			if(ce.getCodigoCentroEscolar()==null)
				entityManager.persist(ce);
			else {
				entityManager.merge(ce);
				entityManager.flush();
			}
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public CentroEscolar findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		CentroEscolar ce = entityManager.find(CentroEscolar.class, code);
		return ce;
	}

}
