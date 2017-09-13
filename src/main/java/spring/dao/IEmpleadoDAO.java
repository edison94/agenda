package spring.dao;


import java.util.List;

import spring.model.Empleado;

public interface IEmpleadoDAO {
	public Empleado getIdempleados(int id);
	
	public void saveOrUpdate(Empleado empleado);
	
	public void delete(int id);
	
	public List<Empleado> listarEmpleados();

	public List<Empleado> List();

	
}


