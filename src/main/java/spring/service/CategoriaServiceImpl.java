package spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.ICategoriaDAO;
import spring.model.Categoria;

@Service
public class CategoriaServiceImpl implements ICategoriaService{
	
	@Autowired
	private ICategoriaDAO dao;

	public List<Categoria> listarCategorias() {
		return dao.list();
	}

	public Categoria getCategoria(int id) {
		return dao.get(id);
	}

	public void addCategoria(Categoria categoria) {
		dao.saveOrUpdate(categoria);
	}

	public void editCategoria(Categoria categoria) {
		dao.saveOrUpdate(categoria);
	}

	public void deleteCategoria(int id) {
		dao.delete(id);
	}

	public void saveOrUpdate(Categoria categoria) {
		dao.saveOrUpdate(categoria);		
	}
	
	

}
