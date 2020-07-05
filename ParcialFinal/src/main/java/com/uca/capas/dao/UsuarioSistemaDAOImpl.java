package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.UsuarioSistema;

@Repository
public class UsuarioSistemaDAOImpl implements UsuarioSistemaDAO{

	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<UsuarioSistema> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.Materia");
		Query query = entityManager.createNativeQuery(sb.toString(), UsuarioSistema.class); 
		List <UsuarioSistema> resultset = query.getResultList();
		return resultset;
	}

	@Override
	public void save(UsuarioSistema user) throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			if(user.getCodigoUser()==null)
				entityManager.persist(user);
			else {
				entityManager.merge(user);
				entityManager.flush();
			}
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	public UsuarioSistema findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		UsuarioSistema user = entityManager.find(UsuarioSistema.class, code);
		return user;
	}

}
