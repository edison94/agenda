package spring.service;

import java.util.List;

import spring.model.Empleado;
import spring.model.Persona;

public interface ISearchService {
	public List<Persona> searchPersonasByNombre(String nombre);
	public List<Persona> searchPersonasByTelefono(String telefono);
	public List<Empleado> searchEmpleadosByDepartamento(String nombre);
}
