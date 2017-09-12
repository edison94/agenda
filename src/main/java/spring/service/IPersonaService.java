package spring.service;

import spring.model.Persona;

public interface IPersonaService {
	public Persona getPersona(int id);
	
	public void saveOrUpdate(Persona persona);
	
	public void addPersona(Persona persona);

}
