package spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.model.Departamento;

@Repository
public class DepartamentoDAOImpl implements IDepartamentoDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public DepartamentoDAOImpl() {
		
	}
	
	public DepartamentoDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Transactional
	public List<Departamento> list() {
		@SuppressWarnings("unchecked")
		List<Departamento> listUser = (List<Departamento>) sessionFactory.getCurrentSession()
				.createCriteria(Departamento.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}

	
	@Transactional
	public void saveOrUpdate(Departamento user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	
	@Transactional
	public void delete(int id) {
		Departamento dept = new Departamento();
		dept.setIddepartamento(id);
		sessionFactory.getCurrentSession().delete(dept);
	}

	
	@Transactional
	public Departamento get(int id) {
		String hql = "from User where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Departamento> list = (List<Departamento>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		
		return null;
	}

}