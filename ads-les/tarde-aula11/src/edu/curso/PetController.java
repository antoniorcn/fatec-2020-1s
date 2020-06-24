package edu.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PetController {
	
	@Autowired
	PetRepository petRepository;
	
	@GetMapping("/pet")
	public ModelAndView getPet() {
		Pet p = new Pet();
		ModelAndView mv = new ModelAndView("pet");
		mv.addObject("PET", p);
		return mv;
	}
	
	@PostMapping("/pet")
	public ModelAndView processaPet(Pet p) {
		petRepository.save(p);
		ModelAndView mv = new ModelAndView("pet");
		mv.addObject("PET", p);
		return mv;
	}

}
