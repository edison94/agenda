package spring.controller;


import java.util.ArrayList;

import javax.persistence.Column;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import antlr.collections.List;

import spring.model.Categoria;
import spring.service.ICategoriaService;

import spring.service.IDepartamentoService;

@Controller
public class AgendaController {
	@Autowired
	private ICategoriaService categoriaService;
	
	@Autowired
	private IDepartamentoService departamentoService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getDepartamentos() {
		ModelAndView model = new ModelAndView("home");
		Categoria c = new Categoria();
		c.setNombre("Sdasdas");
		c.setDescripcion("ooooooo");
		categoriaService.addCategoria(c);
		return model;
	}
	//CREAR EN CONTROLLER GETCATEGORIA
	@RequestMapping("/categoria")
	public ModelAndView handleRequest() throws Exception {
		Object addCategoria;
		List listUsers = ((Object) addCategoria).list();//mostrar lista
		ModelAndView model = new ModelAndView("UserList");//nuevo objeto en la lista
		model.addObject("userList", initializeCategorias());//guardar
		return model;
	}
	//Eliminar categoria
	@RequestMapping(value = "/categoria/delete", method = RequestMethod.GET)
	public ModelAndView deleteUser(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("id"));
		userService.delete(int Id);
		return new ModelAndView("redirect:/");	
	
		
		
		
		
		
		
		//tabla del get categoria
		@ModelAttribute("categorias")
		public String initializeCategorias() {

			List categoria = (List) new ArrayList();
			categoria.add("Programador");
			categoria.add("Analista");
			categoria.add("Tecnico de Recursos Humanos");
			categoria.add("Secretaria");
			categoria.add("Recepcionista");
			categoria.add("Master del Universo");
			return "home";
}
}
