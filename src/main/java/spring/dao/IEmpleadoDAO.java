package spring.dao;


import java.util.List;

import spring.model.Empleado;

public interface IEmpleadoDAO {

	public void saveOrUpdate(Empleado empleado);
	
	public void delete(int id);

	public List<Empleado> list();

	public Empleado get(int id);

	
}


