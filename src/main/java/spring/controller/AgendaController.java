package spring.controller;

import java.util.ArrayList;

import javax.persistence.Column;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import antlr.collections.List;

@Controller
public class AgendaController {
	@RequestMapping(
			value = "/", 
			method = RequestMethod.GET)
	public ModelAndView getDepartamentos() {
		return new ModelAndView("home");
	}
	//CREAR EN CONTROLLER GETCATEGORIA
	@RequestMapping("/")
	public ModelAndView handleRequest() throws Exception {
		List<Categoria> listUsers = addCategoria.list();//mostrar lista
		ModelAndView model = new ModelAndView("UserList");//nuevo objeto en la lista
		model.addObject("userList", listarCategorias);//guardar
		return model;
	}
	
		
		
		
		
		
		
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
