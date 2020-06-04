package edu.curso;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Inicializacao implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext ctx) 
			throws ServletException {
		System.out.println("### Metodo sendo executado no inicio do projeto ###");
		AnnotationConfigWebApplicationContext 
        appCtx = new AnnotationConfigWebApplicationContext();  
		appCtx.register(Config.class);  
		appCtx.setServletContext(ctx);  
		
		Dynamic servlet = ctx.addServlet("dispatcher", new DispatcherServlet(appCtx));
        servlet.addMapping("/");  
        servlet.setLoadOnStartup(1);
		
		
	}

}
