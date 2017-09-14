package spring.service;

import java.util.List;

import spring.model.Telefono;


public interface ITelefonoService {
	public Telefono get(int id);
	
	public void saveOrUpdate(Telefono persona);
	
	public void add(Telefono persona);
	
	public void edit(Telefono persona);
	
	public void delete(int id);
	
	public List<Telefono> listar();

}
