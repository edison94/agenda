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

import spring.model.Telefono;

@Repository
public class TelefonoDAOImpl implements ITelefonoDAO {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	@Transactional
	public Telefono get(int id) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Telefono> query = builder.createQuery(Telefono.class);
		Root<Telefono> root = query.from(Telefono.class);
		query.select(root).where(builder.equal(root.get("idpersonas"), id));
		Query<Telefono> q = session.createQuery(query);
		return q.getSingleResult();
	}

	@Transactional
	public void saveOrUpdate(Telefono persona) {
		sessionFactory.getCurrentSession().saveOrUpdate(persona);
	}
	

	@Transactional
	public void delete(int id) {
		Telefono personaToDelete = new Telefono();
		personaToDelete.setIdtelefonos(id);
		sessionFactory.getCurrentSession().delete(personaToDelete);
		
	}

	@Transactional
	public List<Telefono> listar() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Telefono> query = builder.createQuery(Telefono.class);
		Root<Telefono> root = query.from(Telefono.class);
		query.select(root);
		Query<Telefono> q = session.createQuery(query);
		return q.getResultList();
	}
	
	
}
