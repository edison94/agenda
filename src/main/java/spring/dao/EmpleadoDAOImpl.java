package spring.dao;


import java.util.List;

import javax.management.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.criterion.CriteriaQuery;

import spring.model.Empleado;




public class EmpleadoDAOImpl {

	@Transactional
	public List<Empleado> listarEmpleados() {
		System.out.println("entra a 006");
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Empleado> query = builder.createQuery(Empleado.class);
		Root<Empleado> root = query.from(Empleado.class);
		query.select(root);
		Query<Empleado> q = session.createQuery(query);
		System.out.println("entra a 007");
		return q.getResultList();
	}
}
