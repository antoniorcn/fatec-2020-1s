package edu.curso;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Initializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext ctx) throws ServletException {
		AnnotationConfigWebApplicationContext ctxSpring 
			= new AnnotationConfigWebApplicationContext();
		ctxSpring.setServletContext(ctx);
		ctxSpring.register(WebConfig.class);		
		Dynamic servlet = ctx.addServlet("dispatcher", new DispatcherServlet(ctxSpring));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}

}
