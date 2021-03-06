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

import spring.model.Persona;

@Repository
public class PersonaDAOImpl implements IPersonaDAO {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	@Transactional
	public Persona getPersona(int id) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Persona> query = builder.createQuery(Persona.class);
		Root<Persona> root = query.from(Persona.class);
		query.select(root).where(builder.equal(root.get("idpersonas"), id));
		Query<Persona> q = session.createQuery(query);
		return q.getSingleResult();
	}

	@Transactional
	public void saveOrUpdate(Persona persona) {
		sessionFactory.getCurrentSession().saveOrUpdate(persona);
	}
	

	@Transactional
	public void delete(int id) {
		Persona personaToDelete = new Persona();
		personaToDelete.setIdpersonas(id);
		sessionFactory.getCurrentSession().delete(personaToDelete);
		
	}

	@Transactional
	public List<Persona> listarPersonas() {
		System.out.println("entra a 001");
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Persona> query = builder.createQuery(Persona.class);
		Root<Persona> root = query.from(Persona.class);
		query.select(root);
		Query<Persona> q = session.createQuery(query);
		System.out.println("entra a 002");
		return q.getResultList();
	}
	
	
}
