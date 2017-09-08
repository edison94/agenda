package spring.dao;
// default package
// Generated 08-sep-2017 9:59:39 by Hibernate Tools 5.2.3.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import spring.model.Empleado;

/**
 * Home object for domain model class Empleados.
 * @see .Empleados
 * @author Hibernate Tools
 */
@Stateless
public class EmpleadoDAO {

	private static final Log log = LogFactory.getLog(EmpleadoDAO.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Empleado transientInstance) {
		log.debug("persisting Empleados instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Empleado persistentInstance) {
		log.debug("removing Empleados instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Empleado merge(Empleado detachedInstance) {
		log.debug("merging Empleados instance");
		try {
			Empleado result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Empleado findById(Integer id) {
		log.debug("getting Empleados instance with id: " + id);
		try {
			Empleado instance = entityManager.find(Empleado.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
