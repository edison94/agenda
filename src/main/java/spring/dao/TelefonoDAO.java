package spring.dao;
// default package
// Generated 08-sep-2017 9:59:39 by Hibernate Tools 5.2.3.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import spring.model.Telefono;

/**
 * Home object for domain model class Telefonos.
 * @see .Telefonos
 * @author Hibernate Tools
 */
@Stateless
public class TelefonoDAO {

	private static final Log log = LogFactory.getLog(TelefonoDAO.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Telefono transientInstance) {
		log.debug("persisting Telefonos instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Telefono persistentInstance) {
		log.debug("removing Telefonos instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Telefono merge(Telefono detachedInstance) {
		log.debug("merging Telefonos instance");
		try {
			Telefono result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Telefono findById(Integer id) {
		log.debug("getting Telefonos instance with id: " + id);
		try {
			Telefono instance = entityManager.find(Telefono.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
