package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.model.Categoria;
import spring.service.ICategoriaService;

@Controller
public class AgendaController {
	@Autowired
	private ICategoriaService categoriaService;
	@RequestMapping(
			value = "/", 
			method = RequestMethod.GET)
	public ModelAndView getDepartamentos() {
		ModelAndView model = new ModelAndView("home");
		Categoria c = new Categoria();
		c.setNombre("Director");
		c.setDescripcion("Director de departamento");
		categoriaService.addCategoria(c);
		return model;
	}
}