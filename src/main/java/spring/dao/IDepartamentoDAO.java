package spring.dao;

import java.util.List;

import spring.model.Departamento;

public interface IDepartamentoDAO {
	public List<Departamento> list();
	
	public Departamento get(int id);
	
	public void saveOrUpdate(Departamento departamento);
	
	public void delete(int id);
}