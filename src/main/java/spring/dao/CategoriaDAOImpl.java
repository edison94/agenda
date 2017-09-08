package spring.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import spring.model.Categoria;

@Repository
public class CategoriaDAOImpl implements ICategoriaDAO {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	public List<Categoria> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Categoria> query = builder.createQuery(Categoria.class);
		Root<Categoria> root = query.from(Categoria.class);
		query.select(root);
		Query<Categoria> q = session.createQuery(query);
		List<Categoria> categorias = q.getResultList();
		for (Categoria c : categorias) {
			System.out.println(c);
		}
		return categorias;

	}

	public void saveOrUpdate(Categoria cat) {
		// TODO Auto-generated method stub

	}

	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	public Categoria get(int id) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Categoria> query = builder.createQuery(Categoria.class);
		Root<Categoria> root = query.from(Categoria.class);
		query.select(root);
		Query<Categoria> q = session.createQuery(query);
		List<Categoria> categorias = q.getResultList();
		for (Categoria c : categorias) {
			System.out.println(c);
		}
		return null;
	}

}
