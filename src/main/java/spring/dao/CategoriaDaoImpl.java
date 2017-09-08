package spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import spring.model.Categoria;
import spring.model.Departamento;

public class CategoriaDaoImpl implements ICategoriaDao{

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	public List<Categoria> listarCategorias() {
		@SuppressWarnings("unchecked")
		List<Categoria> listCategoria = (List<Categoria>) sessionFactory.getCurrentSession()
				.createCriteria(Categoria.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listCategoria;
		
	}

	public Categoria getCategoria(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		
	}

	public void editCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		
	}

	public void deleteCategoria(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
