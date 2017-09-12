package spring.service;

import java.util.List;

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
		

	public void editPersona(Persona persona) {
		dao.saveOrUpdate(persona);	
	}
	

	public void deletePersona(int id) {
		dao.delete(id);	
	}

	public List<Persona> listarPersonas() {
		return dao.listarPersonas();
	}
	
	
}
