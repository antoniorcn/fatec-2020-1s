package edu.curso;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan
public class Config implements WebMvcConfigurer {       
	@Bean  
	public UrlBasedViewResolver setupViewResolver() {  
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();  
		resolver.setPrefix("/WEB-INF/jsp/");  
		resolver.setSuffix(".jsp");  
		resolver.setViewClass(JstlView.class);  
		return resolver;  
	}  

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
		.addResourceHandler("/resource/**")
		.addResourceLocations("/resource/");
	}

	@Bean
	public List<Pet> lista() { 
		List<Pet> pets = new ArrayList<>();
		Pet p = new Pet();
		p.setNome("toto");
		p.setRaca("Vira Lata");
		p.setNascimento(LocalDate.now());
		pets.add(p);
		return pets;
	}


}
