package spring.service;

import java.util.List;

import spring.model.Persona;

public interface ISearchService {
	public List<Persona> searchPersonasByNombre(String nombre);
}
