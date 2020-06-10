package edu.curso;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Inicializador implements WebApplicationInitializer  {

	@Override
	public void onStartup(ServletContext ctx) throws ServletException {
		System.out.println("### Executando assim que o projeto ir para o Tomcat ###");
		AnnotationConfigWebApplicationContext 
        	springCTX = new AnnotationConfigWebApplicationContext();  
		springCTX.register(WebConfig.class);
		springCTX.setServletContext(ctx);

		Dynamic servlet = ctx.addServlet("servlet-spring", 
				new DispatcherServlet(springCTX));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}

}
