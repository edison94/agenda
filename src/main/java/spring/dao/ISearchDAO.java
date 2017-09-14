package spring.dao;

import java.util.List;

import spring.model.Empleado;
import spring.model.Persona;

public interface ISearchDAO {
	public List<Persona> searchPersonasByNombre(String nombre);
	public List<Empleado> searchEmpleadosByDepartamento(String departamento);
}
