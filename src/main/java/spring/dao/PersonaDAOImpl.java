package spring.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import spring.model.Persona;

public class PersonaDAOImpl implements IPersonaDAO {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
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
}
