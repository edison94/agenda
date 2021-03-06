package spring.service;

import java.util.List;

import spring.model.Persona;


public interface IPersonaService {
	public Persona getPersona(int id);
	
	public void saveOrUpdate(Persona persona);
	
	public void addPersona(Persona persona);
	
	public void editPersona(Persona persona);
	
	public void deletePersona(int id);
	
	public List<Persona> listarPersonas();

}
