package spring.service;

import java.util.List;

import spring.model.Empleado;
import spring.model.Persona;

public interface ISearchService {
	public List<Persona> searchPersonasByNombre(String nombre);
	public List<Persona> searchPersonasByTelefono(String telefono);
	public List<Persona> searchPersonasByDireccion(String direccion);
	public List<Empleado> searchEmpleadosByDepartamento(String nombre);
	public List<Empleado> searchEmpleadosByDireccion(String direccion);
	public List<Empleado> searchEmpleadosByTelefono(String telefono);
	public List<Empleado> searchEmpleadosByNombre(String nombre);
	public List<Empleado> searchEmpleadosByCategoria(String categoria);
}
