package spring.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


import spring.model.Categoria;

@Repository
public class CategoriaDaoImpl implements ICategoriaDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Categoria> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Categoria> query = builder.createQuery(Categoria.class);
		Root<Categoria> root = query.from(Categoria.class);
		query.select(root);
		Query<Categoria> q = session.createQuery(query);
		List<Categoria> categorias = q.getResultList();
		return categorias;

	}
	
	@Transactional
	public void saveOrUpdate(Categoria cat) {
		sessionFactory.getCurrentSession().saveOrUpdate(cat);
	}
	
	@Transactional
	public void delete(int id) {
		Categoria c= get(id);
		sessionFactory.getCurrentSession().delete(c);
	}
	
	@Transactional
	public Categoria get(int id) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Categoria> query = builder.createQuery(Categoria.class);
		Root<Categoria> root = query.from(Categoria.class);
		query.select(root).where(builder.equal(root.get("idcategorias"),id));
		Query<Categoria> q = session.createQuery(query);
		return q.uniqueResult();
	}

}
