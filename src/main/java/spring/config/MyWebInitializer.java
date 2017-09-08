package spring.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



/*
 * Create a ServletInitializer class by extending AbstractAnnotationConfigDispatcherServletInitializer, 
 * the Servlet 3.0+ container will pick up this class and run it automatically. 
 * 
 * This is the replacement for web.xml.
 * 
 */
 
public class MyWebInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {
 
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { SpringWebConfig.class };
	}
	
	//Importa la configuracion de Spring si aun no lo has hecho
 
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
 
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}
 
}
