package spring.dao;
// default package
// Generated 08-sep-2017 9:59:39 by Hibernate Tools 5.2.3.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import spring.model.Direccion;

/**
 * Home object for domain model class Direcciones.
 * @see .Direcciones
 * @author Hibernate Tools
 */
@Stateless
public class DireccionDAO {

	private static final Log log = LogFactory.getLog(DireccionDAO.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Direccion transientInstance) {
		log.debug("persisting Direcciones instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Direccion persistentInstance) {
		log.debug("removing Direcciones instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Direccion merge(Direccion detachedInstance) {
		log.debug("merging Direcciones instance");
		try {
			Direccion result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Direccion findById(Integer id) {
		log.debug("getting Direcciones instance with id: " + id);
		try {
			Direccion instance = entityManager.find(Direccion.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}