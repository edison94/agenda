package spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	/**************************************************
	 * BEANS
	 **************************************************/
	@ModelAttribute("categoria")
	public Categoria getCategoriaObjectNew() {
		System.out.println("-- Genero una categoria nueva.--");
		return new Categoria();
	}
	
	@ModelAttribute("departamento")
	public Departamento getDepartamentoObjectNew() {
		return new Departamento();
	}
	
	@ModelAttribute("categorias")
	public List<Categoria> getCategorias() {
		return categoriaService.listarCategorias();
	}
	
	@ModelAttribute("departamentos")
	public List<Departamento> getDepartamentos() {
		return departamentoService.listarDepartamentos();
	}
	
	/**************************************************
	 * HOME
	 **************************************************/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		return new ModelAndView("home");
	}
	
	/**************************************************
	 * Categoria
	 **************************************************/
	
	@RequestMapping(value = "/categorias", method = RequestMethod.GET)	
	public ModelAndView getListadoCategorias() {
		ModelAndView model = new ModelAndView("listadoCategorias");
		model.addObject("categorias",categoriaService.listarCategorias());
		return model;
	}
	
	@RequestMapping(value = "/categorias/add", method = RequestMethod.GET)		
	public ModelAndView formCategoria() {
		return new ModelAndView("formCategorias","categoria",getCategoriaObjectNew());
	}
	
	@RequestMapping(value = "/categorias/delete", method = RequestMethod.POST)		
	public ModelAndView deleteCategoria(@RequestParam int id) {
		categoriaService.deleteCategoria(id);
		return new ModelAndView("redirect:/");
	}
	
	/**************************************************
	 * Departamento
	 **************************************************/
	@RequestMapping(value = "/departamentos", method = RequestMethod.GET)	
	public String getListadoDepartamentos() {
		return "Departamentos";
	}
	
	@RequestMapping(value = {"/departamento/add","/departamento/edit"} ,method = RequestMethod.POST)
	public String saveDepartamento(@Valid Departamento departamento, BindingResult result) {
		if (result.hasErrors()) {
			return "formDepartamento";
		}
		departamentoService.saveOrUpdate(departamento);
		return "redirect: grupos";
	}
}