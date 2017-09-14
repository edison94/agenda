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

import spring.model.Categoria;
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
		System.out.println("entra dao");
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
		Query<Persona> q = session.createQuery(query);
		System.out.println("sale DAO");
		System.out.println(q.getResultList());
		return q.getResultList();
	}
	
	

	@Transactional
	public List<Persona> searchPersonasByTelefono(String telefono) {
		System.out.println("entra dao"+telefono);
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Persona> query = builder.createQuery(Persona.class);
		Root<Persona> root = query.from(Persona.class);
		Join<Persona,Telefono> join = root.join("telefonos");
		
		System.out.println("works at least until 001");
		Predicate like = builder.like( join.<String>get("telefono"),"%"+telefono+"%" );
		System.out.println("works at least until 002");
		query.select(root);
		query.where(like);
		Query<Persona> q = session.createQuery(query);
		System.out.println("sale DAO");
		System.out.println(q.getResultList());
		return q.getResultList();
	}

	@Transactional
	public List<Persona> searchPersonasByDireccion(String direccion) {
		System.out.println("entra dao");
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Persona> query = builder.createQuery(Persona.class);
		Root<Persona> root = query.from(Persona.class);
		Join<Persona,Telefono> join = root.join("direccion");
		
		System.out.println("works at least until 001");
		Predicate like = builder.or(
				builder.like( join.<String>get("direccion"),"%"+direccion+"%" ),
				builder.like( join.<String>get("codPostal"),"%"+direccion+"%" ),
				builder.like( join.<String>get("localidad"),"%"+direccion+"%" ),
				builder.like( join.<String>get("provincia"),"%"+direccion+"%" )
				
			);
		System.out.println("works at least until 002");
		query.select(root);
		query.where(like);
		Query<Persona> q = session.createQuery(query);
		System.out.println("sale DAO");
		System.out.println(q.getResultList());
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
		Query<Empleado> q = session.createQuery(query);
		return q.getResultList();
	}
	
	

}
