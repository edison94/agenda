package spring.dao;

import spring.model.Persona;

public interface IPersonaDAO {
	public Persona getPersona(int id);
	
	public void saveOrUpdate(Persona persona);
}
