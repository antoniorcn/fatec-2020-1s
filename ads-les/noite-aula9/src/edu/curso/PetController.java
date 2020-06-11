package edu.curso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class PetController {
	
	@Autowired
	private List<Pet> lista;
	
	@RequestMapping(value = "/pet", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView pet(@ModelAttribute("petAtual") Pet p) { 
		System.out.println("*** Pet: " + p);
		if (p.getNome() != null ) { 
			lista.add(p);
		}
		Pet pet = new Pet();
		
		ModelAndView mv = new ModelAndView("pet");
		mv.addObject("petAtual", pet);
		mv.addObject("petLista", lista);
		return mv;
	}
}
