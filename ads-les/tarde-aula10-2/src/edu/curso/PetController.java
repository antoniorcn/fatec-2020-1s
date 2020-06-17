package edu.curso;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PetController {
	
	@RequestMapping("/teste")
	public ModelAndView teste() { 
		String texto = "Texto de teste";
		ModelAndView mv = new ModelAndView("teste");
		mv.addObject("TEXTO", texto);
		return mv;
	}
	
	@RequestMapping("/pet")
	public ModelAndView getPet() {
		Pet p = new Pet();
		p.setNome("Totó");
		p.setRaca("buldog");
		ModelAndView mv = new ModelAndView("pet");
		mv.addObject("PET", p);
		return mv;
	}

}
