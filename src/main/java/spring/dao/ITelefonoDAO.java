package spring.dao;

import java.util.List;

import spring.model.Telefono;

public interface ITelefonoDAO {
	public Telefono get(int id);
	
	public void saveOrUpdate(Telefono persona);
	
	public void delete(int id);
	
	public List<Telefono> listar();
}
