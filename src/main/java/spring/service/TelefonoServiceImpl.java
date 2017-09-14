package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.dao.ITelefonoDAO;
import spring.model.Telefono;

@Service
public class TelefonoServiceImpl implements ITelefonoService{
	
	@Autowired
	private ITelefonoDAO dao;

	public Telefono get(int id) {
		return dao.get(id);
	}

	public void saveOrUpdate(Telefono persona) {
		dao.saveOrUpdate(persona);
		
	}

	public void add(Telefono persona) {
		dao.saveOrUpdate(persona);	
	}
		

	public void edit(Telefono persona) {
		dao.saveOrUpdate(persona);	
	}
	

	public void delete(int id) {
		dao.delete(id);	
	}

	public List<Telefono> listar() {
		return dao.listar();
	}
	
	
}
