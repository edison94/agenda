package spring.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import spring.exception.AgendaException;
import spring.model.Categoria;
import spring.model.Departamento;
import spring.model.Empleado;
import spring.model.Persona;
import spring.service.ICategoriaService;
import spring.service.IDepartamentoService;
import spring.service.IEmpleadoService;
import spring.service.IPersonaService;
import spring.service.ISearchService;

@Controller
public class AgendaController {
	@Autowired
	private ICategoriaService categoriaService;
	
	@Autowired
	private IDepartamentoService departamentoService;
	
	@Autowired
	private IPersonaService personaService;
	
	@Autowired
	private IEmpleadoService empleadoService;
	
	@Autowired
	private ISearchService searchService;
	
	
	/**************************************************
	 * BEANS
	 **************************************************/
	@ModelAttribute("categoria")
	public Categoria getCategoriaObjectNew() {
		return new Categoria();
	}
	
	@ModelAttribute("departamento")
	public Departamento getDepartamentoObjectNew() {
		return new Departamento();
	}
	
	@ModelAttribute("persona")
	public Persona getPersonaObjectNew() {
		return new Persona();
	}
	
	@ModelAttribute("empleado")
	public Empleado getEmpleadoObjectNew() {
		return new Empleado();
	}
	
	@ModelAttribute("categorias")
	public List<Categoria> getCategorias() {
		return categoriaService.listarCategorias();
	}
	
	@ModelAttribute("departamentos")
	public List<Departamento> getDepartamentos() {
		return departamentoService.listarDepartamentos();
	}
	
	@ModelAttribute("personas")
	public List<Persona> getPersonas(){
		return personaService.listarPersonas();
	}
	
	@ModelAttribute("empleados")
	public List<Empleado> getEmpleados(){
		return empleadoService.listarEmpleados();
	}
	
	/**************************************************
	 * HOME
	 **************************************************/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		System.out.println("entra 0001");
		searchService.searchPersonasByNombre("hola");
		return new ModelAndView("home");
	}
	
	/**************************************************
	 * Categoria
	 **************************************************/
	
	@RequestMapping(value = "/categorias", method = RequestMethod.GET)	
	public String getListadoCategorias() {
		return "categorias";
	}
	
	@RequestMapping(value = {"/categorias/add","/categorias/edit"} ,method = RequestMethod.POST)
	public String saveCategoria(@Valid Categoria categoria, BindingResult result) {
		if (result.hasErrors()) {
			return "formCategoria";
		}
		categoriaService.saveOrUpdate(categoria);
		return "redirect: /agenda/categorias";
	}
	
	@RequestMapping(value = "/categorias/add", method = RequestMethod.GET)		
	public String formCategoria() {
		return "formCategoria";
	}
	
	@RequestMapping(value = "/categorias/edit", method = RequestMethod.GET)		
	public String editCategoria(@RequestParam("id")int id, ModelMap map) {		
		map.addAttribute("categoria",categoriaService.getCategoria(id));
		return "formCategoria";
	}
	
	@RequestMapping(value = "/categorias/delete", method = RequestMethod.GET)		
	public String deleteCategoria(@RequestParam int id) {
		categoriaService.deleteCategoria(id);
		return "redirect: /agenda/categorias";
	}
	
	/**************************************************
	 * Persona
	 **************************************************/
	
	/*@RequestMapping(value = "/personas", method = RequestMethod.GET)	
	public String getListadoPersonas() {
		return "personas";
	}
	
	
	
	@RequestMapping(value = {"/personas/add","/personas/edit"} ,method = RequestMethod.POST)
	public String savePersona(@Valid Persona persona, BindingResult result) {
		if (result.hasErrors()) {
			return "formPersona";
		}
		personaService.saveOrUpdate(persona);
		return "redirect: /agenda/personas";
	}
	
	
	@RequestMapping(value = "/personas/add", method = RequestMethod.GET)		
	public String formPersonas() {
		return "formPersona";
	}
	
	@RequestMapping(value = "/personas/edit", method = RequestMethod.GET)		
	public String editPersona(@RequestParam("id")int id, ModelMap map) {		
		map.addAttribute("persona",personaService.getPersona(id));
		return "formPersona";
	}
	
	
	@RequestMapping(value = "/personas/delete", method = RequestMethod.GET)		
	public String deletePersona(@RequestParam int id) {
		personaService.deletePersona(id);
		return "redirect: /agenda/personas";
	}*/

	/**************************************************
	 * Departamento
	 **************************************************/
	@RequestMapping(value = "/departamentos", method = RequestMethod.GET)	
	public String getListadoDepartamentos() {
		return "departamentos";
	}
	
	@RequestMapping(value = "/departamentos/add", method = RequestMethod.GET)		
	public String formDepartamento() {
		return "formDepartamento";
	}
	
	@RequestMapping(value = {"/departamentos/add","/departamentos/edit"} ,method = RequestMethod.POST)
	public String saveDepartamento(@Valid Departamento departamento, BindingResult result) {
		if (result.hasErrors()) {
			return "formDepartamento";
		}
		departamentoService.saveOrUpdate(departamento);
		return "redirect: /agenda/departamentos";
	}
	
	@RequestMapping(value = "/departamentos/edit", method = RequestMethod.GET)		
	public String editDepartamento(@RequestParam("id")int id, ModelMap map) {		
		map.addAttribute("departamento",departamentoService.get(id));
		return "formDepartamento";
	}
	
	@RequestMapping(value = "/departamentos/delete", method = RequestMethod.GET)
	public String deleteDepartamento(@RequestParam("id")int id) throws AgendaException {
		try {
			departamentoService.delete(id);
		} catch (Exception e) {
			throw new AgendaException("redirect: /agenda/departamentos","No se puede borrar");
		}
		return "redirect: /agenda/departamentos";
	}

	
	@ResponseStatus(value=HttpStatus.CONFLICT,reason="Data integrity violation") 
	@ExceptionHandler(AgendaException.class)
	public void handleCustomException() {
		//esto se haria mejor con ajax
	}

	
	/**************************************************
	 * Empleado
	 **************************************************/
	@RequestMapping(value = "/empleados", method = RequestMethod.GET)	
	public String getListadoEmpleados() {
		return "empleados";
	}
}
