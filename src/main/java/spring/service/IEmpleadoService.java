package spring.service;

import java.util.List;

import spring.model.Empleado;
;

public interface IEmpleadoService {
public List<Empleado> listarEmpleados();
	
	public Empleado get(int id);
	
	public void add(Empleado empleados);
	
	public void edit(Empleado empleados);
	
	public void delete(int id);

	public void saveOrUpdate(Empleado empleados);

}
