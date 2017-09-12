package spring.dao;

import java.util.List;

import spring.model.Persona;

public interface IPersonaDAO {
	public Persona getPersona(int id);
	
	public void saveOrUpdate(Persona persona);
	
	public void delete(int id);
	
	public List<Persona> listarPersonas();
}
