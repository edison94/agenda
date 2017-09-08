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
import spring.model.Departamento;

@Repository
public class DepartamentoDAOImpl implements IDepartamentoDAO {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	public DepartamentoDAOImpl() {

	}

	public DepartamentoDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Departamento> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Departamento> query = builder.createQuery(Departamento.class);
		Root<Departamento> root = query.from(Departamento.class);
		query.select(root);
		Query<Departamento> q = session.createQuery(query);
		return q.getResultList();

	}

	@Transactional
	public void saveOrUpdate(Departamento dept) {
		sessionFactory.getCurrentSession().saveOrUpdate(dept);
	}

	@Transactional
	public void delete(int id) {
		Departamento deptToDelete = new Departamento();
		deptToDelete.setIddepartamento(id);
		sessionFactory.getCurrentSession().delete(deptToDelete);
	}
	@Transactional
	public Departamento get(int id) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Departamento> query = builder.createQuery(Departamento.class);
		Root<Departamento> root = query.from(Departamento.class);
		query.select(root).where(builder.equal(root.get("iddepartamento"), id));
		Query<Departamento> q = session.createQuery(query);
		return q.getSingleResult();
	}

}