package spring.service;

import org.springframework.beans.factory.annotation.Autowired;

import spring.dao.IPersonaDAO;
import spring.model.Persona;

public class PersonaServiceImpl implements IPersonaService{
	
	@Autowired
	private IPersonaDAO dao;

	public Persona getPersona(int id) {
		return dao.getPersona(id);
	}

	public void saveOrUpdate(Persona persona) {
		dao.saveOrUpdate(persona);
		
	}

	public void addPersona(Persona persona) {
		dao.saveOrUpdate(persona);	
	}
	
	
}
