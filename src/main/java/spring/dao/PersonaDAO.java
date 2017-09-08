package spring.dao;
// default package
// Generated 08-sep-2017 9:59:39 by Hibernate Tools 5.2.3.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import spring.model.Persona;

/**
 * Home object for domain model class Personas.
 * @see .Personas
 * @author Hibernate Tools
 */
@Stateless
public class PersonaDAO {

	private static final Log log = LogFactory.getLog(PersonaDAO.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Persona transientInstance) {
		log.debug("persisting Personas instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Persona persistentInstance) {
		log.debug("removing Personas instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Persona merge(Persona detachedInstance) {
		log.debug("merging Personas instance");
		try {
			Persona result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Persona findById(Integer id) {
		log.debug("getting Personas instance with id: " + id);
		try {
			Persona instance = entityManager.find(Persona.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
