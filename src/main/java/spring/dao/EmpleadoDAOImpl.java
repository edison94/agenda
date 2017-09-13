package spring.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import spring.model.Departamento;
import spring.model.Empleado;

public class EmpleadoDAOImpl implements IEmpleadoDAO {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	public Empleado getEmpleado(int id) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Empleado> query = builder.createQuery(Empleado.class);
		Root<Empleado> root = query.from(Empleado.class);
		query.select(root).where(builder.equal(root.get("iddepartamento"), id));
		Query<Empleado> q = session.createQuery(query);
		return q.getSingleResult();
	}

	public void saveOrUpdate(Empleado empleado) {
		// TODO Auto-generated method stub
		
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	public java.util.List<Empleado> listarEmpleados() {
		// TODO Auto-generated method stub
		return null;
	}

	public java.util.List<Empleado> List() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
