package spring.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import spring.model.Empleado;
import spring.model.Persona;
import spring.model.Telefono;

@Repository
public class SearchDAOImpl implements ISearchDAO {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	
	@Transactional
	public List<Persona> searchPersonasByNombre(String nombre) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Persona> query = builder.createQuery(Persona.class);
		Root<Persona> root = query.from(Persona.class);
		Predicate like = builder.or(
				builder.like(root.<String>get("nombre"), "%"+nombre+"%"),
				builder.like(root.<String>get("apellido1"), "%"+nombre+"%"),
				builder.like(root.<String>get("apellido2"), "%"+nombre+"%")
				);
		query.select(root);
		query.where(like);
		query.distinct(true);
		Query<Persona> q = session.createQuery(query);
		return q.getResultList();
	}
	
	@Transactional
	public List<Persona> searchPersonasByTelefono(String telefono) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Persona> query = builder.createQuery(Persona.class);
		Root<Persona> root = query.from(Persona.class);
		Join<Persona,Telefono> join = root.join("telefonos");
	
		Predicate like = builder.like( join.<String>get("telefono"),"%"+telefono+"%" );
		query.select(root);
		query.where(like);
		query.distinct(true);
		Query<Persona> q = session.createQuery(query);
		return q.getResultList();
	}

	@Transactional
	public List<Persona> searchPersonasByDireccion(String direccion) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Persona> query = builder.createQuery(Persona.class);
		Root<Persona> root = query.from(Persona.class);
		Join<Persona,Telefono> join = root.join("direccion");
		
		Predicate like = builder.or(
				builder.like( join.<String>get("direccion"),"%"+direccion+"%" ),
				builder.like( join.<String>get("codPostal"),"%"+direccion+"%" ),
				builder.like( join.<String>get("localidad"),"%"+direccion+"%" ),
				builder.like( join.<String>get("provincia"),"%"+direccion+"%" )
			);
		query.select(root);
		query.where(like);
		query.distinct(true);
		Query<Persona> q = session.createQuery(query);
		return q.getResultList();
	}

	@Transactional
	public List<Empleado> searchEmpleadosByDepartamento(String departamento) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Empleado> query = builder.createQuery(Empleado.class);
		Root<Empleado> root = query.from(Empleado.class);
		Predicate like = builder.and(
			    builder.like( root.get("departamentos").<String>get("nombre"),"%"+departamento+"%" )
			);
		query.select(root);
		query.where(like);
		query.distinct(true);
		Query<Empleado> q = session.createQuery(query);
		return q.getResultList();
	}

	@Transactional
	public List<Empleado> searchEmpleadosByCategoria(String categoria) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Empleado> query = builder.createQuery(Empleado.class);
		Root<Empleado> root = query.from(Empleado.class);
		Predicate like = builder.and(
			    builder.like( root.get("categorias").<String>get("nombre"),"%"+categoria+"%" )
			);
		query.select(root);
		query.where(like);
		Query<Empleado> q = session.createQuery(query);
		return q.getResultList();
	}
	
	@Transactional
	public List<Empleado> searchEmpleadosByTelefono(String telefono) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Empleado> query = builder.createQuery(Empleado.class);
		Root<Empleado> root = query.from(Empleado.class);
		Predicate like = builder.and(
			    builder.like( root.get("personas").get("telefonos").<String>get("telefono"),"%"+telefono+"%" )
			);
		query.select(root);
		query.where(like);
		Query<Empleado> q = session.createQuery(query);
		return q.getResultList();
	}
	
	@Transactional
	public List<Empleado> searchEmpleadosByNombre(String nombre) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Empleado> query = builder.createQuery(Empleado.class);
		Root<Empleado> root = query.from(Empleado.class);
		Predicate like = builder.or(
				builder.like(root.get("personas").<String>get("nombre"), "%"+nombre+"%"),
				builder.like(root.get("personas").<String>get("apellido1"), "%"+nombre+"%"),
				builder.like(root.get("personas").<String>get("apellido2"), "%"+nombre+"%")
				);
		query.select(root);
		query.where(like);
		Query<Empleado> q = session.createQuery(query);
		return q.getResultList();
	}
	
	@Transactional
	public List<Empleado> searchEmpleadosByDireccion(String direccion) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Empleado> query = builder.createQuery(Empleado.class);
		Root<Empleado> root = query.from(Empleado.class);		
		Predicate like = builder.or(
				builder.like( root.get("personas").get("direccion").<String>get("direccion"),"%"+direccion+"%" ),
				builder.like( root.get("personas").get("direccion").<String>get("codPostal"),"%"+direccion+"%" ),
				builder.like( root.get("personas").get("direccion").<String>get("localidad"),"%"+direccion+"%" ),
				builder.like( root.get("personas").get("direccion").<String>get("provincia"),"%"+direccion+"%" )
			);
		query.select(root);
		query.where(like);
		Query<Empleado> q = session.createQuery(query);
		return q.getResultList();
	}
}
