package spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.model.Categoria;

@Repository
public class CategoriaImpl implements ICategoriaDao{

	@Autowired
	private SessionFactory sessionFactory;

	public CategoriaImpl() {
		
	}
	
	public CategoriaImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Categoria> list() {
		@SuppressWarnings("unchecked")
		List<Categoria> listUser = (List<Categoria>) sessionFactory.getCurrentSession()
				.createCriteria(Categoria.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}

	@Transactional
	public void saveOrUpdate(Categoria cat) {
		sessionFactory.getCurrentSession().saveOrUpdate(cat);
	}

	@Transactional
	public void delete(int id) {
		Categoria catToDelete = new Categoria();
		catToDelete.setIdcategorias(id);
		sessionFactory.getCurrentSession().delete(catToDelete);
	}

	@Transactional
	public Categoria get(int id) {
		String hql = "from User where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Categoria> listUser = (List<Categoria>) query.list();
		
		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		
		return null;
	}

}
