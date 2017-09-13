package spring.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.IEmpleadoDAO;
import spring.model.Empleado;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {
	@Autowired
	private IEmpleadoDAO dao;
	
	public List<Empleado> listarEmpleados() {
		return dao.list();
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


