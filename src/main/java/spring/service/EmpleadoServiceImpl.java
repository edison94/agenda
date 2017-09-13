package spring.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import spring.dao.IEmpleadoDAO;
import spring.model.Empleado;

public class EmpleadoServiceImpl implements IEmpleadoService {
	@Autowired
	private IEmpleadoDAO dao;
	
	public List<Empleado> listarEmpleados() {
		return null;
	} 
	
	

	public Empleado get(int id) {
		return dao.getIdempleados(id);
	}

	public void add(Empleado empleado) {
		dao.saveOrUpdate(empleado);
	}

	public void edit(Empleado empleado) {
		dao.saveOrUpdate(empleado);
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public  void saveOrUpdate(Empleado empleado) {
		dao.saveOrUpdate(empleado);
	}

	

}


