package spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.ICategoriaDao;
import spring.model.Categoria;

@Service
public class CategoriaServiceImpl implements ICategoriaService{
	
	@Autowired
	private ICategoriaDao dao;
	
	public List<Categoria> listarCategorias() {
		return dao.listarCategorias();
	}

	public Categoria getCategoria(int id) {
		return dao.getCategoria(id);
	}

	public void addCategoria(Categoria categoria) {
		dao.addCategoria(categoria);
	}

	public void editCategoria(Categoria categoria) {
		dao.editCategoria(categoria);
	}

	public void deleteCategoria(int id) {
		dao.deleteCategoria(id);
	}

}
