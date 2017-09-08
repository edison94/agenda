package spring.dao;

import java.util.List;

import spring.model.Categoria;

public interface ICategoriaDao {
	public List<Categoria> list();
	public void saveOrUpdate(Categoria cat);
	public void delete(int id);
	public Categoria get(int id);
}
