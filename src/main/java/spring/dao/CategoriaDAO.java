package spring.dao;
// default package
// Generated 08-sep-2017 9:59:39 by Hibernate Tools 5.2.3.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import spring.model.Categoria;

/**
 * Home object for domain model class Categorias.
 * @see .Categorias
 * @author Hibernate Tools
 */
@Stateless
public class CategoriaDAO {

	private static final Log log = LogFactory.getLog(CategoriaDAO.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Categoria transientInstance) {
		log.debug("persisting Categorias instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Categoria persistentInstance) {
		log.debug("removing Categorias instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Categoria merge(Categoria detachedInstance) {
		log.debug("merging Categorias instance");
		try {
			Categoria result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Categoria findById(Integer id) {
		log.debug("getting Categorias instance with id: " + id);
		try {
			Categoria instance = entityManager.find(Categoria.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
