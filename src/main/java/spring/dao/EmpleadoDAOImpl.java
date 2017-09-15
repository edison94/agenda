package spring.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.model.Empleado;

@Repository
public class EmpleadoDAOImpl implements IEmpleadoDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void saveOrUpdate(Empleado empleado) {
		sessionFactory.getCurrentSession().saveOrUpdate(empleado);
	}

	@Transactional
	public void delete(int id) {
		Empleado e = new Empleado();
		e.setIdempleados(id);
		sessionFactory.getCurrentSession().remove(e);
	}

	@Transactional
	public List<Empleado> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Empleado> query = builder.createQuery(Empleado.class);
		Root<Empleado> root = query.from(Empleado.class);
		query.select(root);
		Query<Empleado> q = session.createQuery(query);
		return q.getResultList();
	}

	@Transactional
	public Empleado get(int id) {
		return sessionFactory.getCurrentSession().find(Empleado.class, id);
	}
}
