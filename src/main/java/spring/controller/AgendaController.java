package spring.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	public String getListadoCategorias() {
		return "Categorias";
	}
	
	@RequestMapping(value = {"/categorias/add","/categorias/edit"} ,method = RequestMethod.POST)
	public String saveCategoria(@Valid Categoria categoria, BindingResult result) {
		if (result.hasErrors()) {
			return "FormCategoria";
		}
		categoriaService.saveOrUpdate(categoria);
		return "redirect: /agenda/categorias";
	}
	
	@RequestMapping(value = "/categorias/add", method = RequestMethod.GET)		
	public String formCategoria() {
		return "FormCategoria";
	}
	
	@RequestMapping(value = "/categorias/edit", method = RequestMethod.GET)		
	public String editCategoria(@RequestParam("id")int id, ModelMap map) {		
		map.addAttribute("categoria",categoriaService.getCategoria(id));
		return "FormCategoria";
	}
	
	@RequestMapping(value = "/categorias/delete", method = RequestMethod.GET)		
	public String deleteCategoria(@RequestParam int id) {
		categoriaService.deleteCategoria(id);
		return "redirect: /agenda/categorias";
	}
	
	/**************************************************
	 * Departamento
	 **************************************************/
	@RequestMapping(value = "/departamentos", method = RequestMethod.GET)	
	public String getListadoDepartamentos() {
		return "Departamentos";
	}
	
	@RequestMapping(value = "/departamentos/add", method = RequestMethod.GET)		
	public String formDepartamento() {
		return "FormDepartamento";
	}
	
	@RequestMapping(value = {"/departamentos/add","/departamentos/edit"} ,method = RequestMethod.POST)
	public String saveDepartamento(@Valid Departamento departamento, BindingResult result) {
		if (result.hasErrors()) {
			return "FormDepartamento";
		}
		departamentoService.saveOrUpdate(departamento);
		return "redirect: /agenda/departamentos";
	}
	
	@RequestMapping(value = "/departamentos/edit", method = RequestMethod.GET)		
	public String editDepartamento(@RequestParam("id")int id, ModelMap map) {		
		map.addAttribute("departamento",departamentoService.get(id));
		return "FormDepartamento";
	}
	
	@RequestMapping(value = "/departamentos/delete", method = RequestMethod.GET)
	public String deleteDepartamento(@RequestParam("id") int id) {
		departamentoService.delete(id);
		return "redirect: /agenda/departamentos";
	}
}
