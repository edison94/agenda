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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import spring.model.Categoria;
import spring.model.Persona;

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
		query.select(root);
		Query<Persona> q = session.createQuery(query);
		List<Persona> personas = q.getResultList();
		
		System.out.println("No ha petado");
		System.out.println(personas);
		return personas;
	}
	
	

}
