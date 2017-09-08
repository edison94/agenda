package spring.service;

import java.util.List;

import spring.model.Departamento;

public interface IDepartamentoService {
	public List<Departamento> listar();
	
	public Departamento get(int id);
	
	public void add(Departamento departamento);
	
	public void edit(Departamento departamento);
	
	public void delete(int id);
}
