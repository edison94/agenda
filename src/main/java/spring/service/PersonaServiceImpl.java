package spring.service;

import org.springframework.beans.factory.annotation.Autowired;

import spring.dao.IPersonaDAO;
import spring.model.Persona;

public class PersonaServiceImpl implements IPersonaService{
	
	@Autowired
	private IPersonaDAO dao;

	public Persona get(int id) {
		return dao.getPersona(id);
	}

}
