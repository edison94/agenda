package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.model.Categoria;
import spring.model.Departamento;
import spring.service.ICategoriaService;
import spring.service.IDepartamentoService;

@Controller
public class AgendaController {
	
	@Autowired
	private ICategoriaService categoriaService;
	@Autowired
	private IDepartamentoService departamentoService;
	
	@ModelAttribute("categoria")
	public Categoria getCategoriaObjectNew() {
		System.out.println("-- Genero una categoria nueva.--");
		return new Categoria();
	}
	
	@ModelAttribute("categoria")
	public Categoria getDeObjectNew() {
		System.out.println("-- Genero una categoria nueva.--");
		return new Categoria();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getDepartamentos() {
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/categoria/new", method = RequestMethod.GET)	
	public String initForm() {
		return "form1";
	}
	
	@RequestMapping(value = "/categoria/addCategoria", method = RequestMethod.POST)		
	public String altaCategoria() {
		return "form2";
	}
	
	@RequestMapping(value = "/departamento/editDepartamento", method = RequestMethod.POST)		
	public String editDepartamento(@ModelAttribute Departamento d) {
		departamentoService.edit(d);
		return "form2";
	}
}