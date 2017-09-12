package spring.service;

import java.util.List;

import spring.model.Categoria;

public interface ICategoriaService {
	public List<Categoria> listarCategorias();
	
	public Categoria getCategoria(int id);
	
	public void addCategoria(Categoria categoria);
	
	public void editCategoria(Categoria categoria);
	
	public void deleteCategoria(int id);
	
	public void saveOrUpdate(Categoria categoria);
}
