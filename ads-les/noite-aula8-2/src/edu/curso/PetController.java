package edu.curso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PetController {
	
	@Autowired
	ApplicationContext appCtx;
	
	@RequestMapping("/pet")
	public ModelAndView pet() { 
		List<Pet> lista = (List<Pet>)appCtx.getBean("lista");
		
		ModelAndView mv = new ModelAndView("pet");
		mv.addObject("mensagem", "Pet não cadastrado");
		mv.addObject("pet", new Pet());
		mv.addObject("lista", lista);
		return mv;
	}
	
	@RequestMapping("/petAdicionar")
	public ModelAndView petAdicionar(@RequestAttribute("pet") Pet p ) { 
		List<Pet> lista = (List<Pet>)appCtx.getBean("lista");
		lista.add(p);
		ModelAndView mv = new ModelAndView("pet");
		mv.addObject("mensagem", "Pet adicionado com sucesso");
		mv.addObject("lista", lista);
		return mv;
	}
}
