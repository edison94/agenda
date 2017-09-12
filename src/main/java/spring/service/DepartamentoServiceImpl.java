package spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.IDepartamentoDAO;
import spring.model.Departamento;

@Service
public class DepartamentoServiceImpl implements IDepartamentoService{
	
	@Autowired
	private IDepartamentoDAO dao;
	
	public List<Departamento> listarDepartamentos() {
		return dao.list();
	}

	public Departamento get(int id) {
		return dao.get(id);
	}

	public void add(Departamento departamento) {
		dao.saveOrUpdate(departamento);
	}

	public void edit(Departamento departamento) {
		dao.saveOrUpdate(departamento);
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public void saveOrUpdate(Departamento departamento) {
		dao.saveOrUpdate(departamento);
	}

	

}
