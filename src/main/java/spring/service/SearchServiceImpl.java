package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.dao.ISearchDAO;
import spring.model.Empleado;
import spring.model.Persona;

@Service
public class SearchServiceImpl implements ISearchService {

	@Autowired
	private ISearchDAO dao;
	
	public List<Persona> searchPersonasByNombre(String nombre) {
		return dao.searchPersonasByNombre(nombre);
	}
	
	
	public List<Persona> searchPersonasByTelefono(String telefono) {	
		return dao.searchPersonasByTelefono(telefono);
	}


	public List<Persona> searchPersonasByDireccion(String direccion) {
		return dao.searchPersonasByDireccion(direccion);
	}


	public List<Empleado> searchEmpleadosByDepartamento(String nombre) {
		return dao.searchEmpleadosByDepartamento(nombre);
	}


	public List<Empleado> searchEmpleadosByDireccion(String direccion) {
		return dao.searchEmpleadosByDireccion(direccion);
	}


	public List<Empleado> searchEmpleadosByTelefono(String telefono) {
		return dao.searchEmpleadosByTelefono(telefono);
	}


	public List<Empleado> searchEmpleadosByNombre(String nombre) {
		return dao.searchEmpleadosByNombre(nombre);
	}


	public List<Empleado> searchEmpleadosByCategoria(String categoria) {
		return dao.searchEmpleadosByCategoria(categoria);
	}
	
}
