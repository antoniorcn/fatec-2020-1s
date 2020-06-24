package edu.curso;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView processaPet(Pet p, @RequestParam("cmd") String cmd) {
		String msg = null;
		ModelAndView mv = new ModelAndView("pet");
		mv.addObject("PET", p);
		if ("adicionar".equals(cmd)) {
			petRepository.save(p);
			mv.addObject("PET", new Pet());
			msg = String.format("Pet %s foi adicionado com sucesso", p.getNome());
		} else if ("pesquisar".equals(cmd)) { 
			Set<Pet> pets = petRepository.searchByNome(p.getNome());
			msg = String.format("Foram encontrados %d pets", pets.size());
			if (pets.size() > 0) { 
				mv.addObject("LISTA", pets);
			}
		}
		mv.addObject("MENSAGEM", msg);
		return mv;
	}

}
