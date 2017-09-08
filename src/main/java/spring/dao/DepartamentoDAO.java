package spring.dao;
// default package
// Generated 08-sep-2017 9:59:39 by Hibernate Tools 5.2.3.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import spring.model.Departamento;

/**
 * Home object for domain model class Departamentos.
 * @see .Departamentos
 * @author Hibernate Tools
 */
@Stateless
public class DepartamentoDAO {

	private static final Log log = LogFactory.getLog(DepartamentoDAO.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Departamento transientInstance) {
		log.debug("persisting Departamentos instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Departamento persistentInstance) {
		log.debug("removing Departamentos instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Departamento merge(Departamento detachedInstance) {
		log.debug("merging Departamentos instance");
		try {
			Departamento result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Departamento findById(Integer id) {
		log.debug("getting Departamentos instance with id: " + id);
		try {
			Departamento instance = entityManager.find(Departamento.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
