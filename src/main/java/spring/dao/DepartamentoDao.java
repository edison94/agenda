package spring.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import spring.model.Departamento;

public class DepartamentoDao {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Departamento> list() {
		@SuppressWarnings("unchecked")
		List<Departamento> listUser = (List<Departamento>) sessionFactory.getCurrentSession()
				.createCriteria(Departamento.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}
	
	@Transactional
	public void saveOrUpdate(Departamento d) {
		System.out.println(d);
		sessionFactory.getCurrentSession().saveOrUpdate(d);
	}
}
