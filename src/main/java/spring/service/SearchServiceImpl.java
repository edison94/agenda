package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.dao.ISearchDAO;
import spring.model.Persona;

@Service
public class SearchServiceImpl implements ISearchService {

	@Autowired
	private ISearchDAO dao;
	
	public List<Persona> searchPersonasByNombre(String nombre) {
		return dao.searchPersonasByNombre(nombre);
	}
	
	
}