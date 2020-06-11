package edu.curso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class PetController {
	
	@Autowired
	private List<Pet> lista;
	
	@GetMapping("/pet")
	public ModelAndView pet() { 
		System.out.println("### Controller Executado ###");
		Pet p = new Pet();
		p.setNome("Rex");
		
		ModelAndView mv = new ModelAndView("pet");
		mv.addObject("petAtual", p);
		return mv;
	}
	
	@PostMapping("/petController")
	public ModelAndView petController(@ModelAttribute("petAtual") Pet p) {
		lista.add(p);
		
		p = new Pet();
		ModelAndView mv = new ModelAndView("pet");
		mv.addObject("petAtual", p);
		return mv;
	}

}
