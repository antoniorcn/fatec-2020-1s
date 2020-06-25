package edu.curso;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class PetController {
	@Autowired
	private PetRepository petRepository;
	
	@GetMapping(value = "/pet")
	public ModelAndView pet() { 
		Pet pet = new Pet();
		ModelAndView mv = new ModelAndView("pet");
		mv.addObject("petAtual", pet);
		return mv;
	}
	
	@PostMapping(value = "/pet")
	public ModelAndView processaPet(@ModelAttribute("petAtual") Pet p, 
			@RequestParam("cmd") String cmd) { 
		ModelAndView mv = new ModelAndView("pet");
		String msg = null;
		if ("adicionar".equals(cmd)) { 
			mv.addObject("petAtual", new Pet());
			petRepository.save(p);
			msg = String.format("O pet %s foi adicionado com sucesso", p.getNome());
		} else if ("pesquisar".equals(cmd)) { 
			Set<Pet> lista = petRepository.searchByNome(p.getNome());
			msg = String.format("Foram encontrados %d pets com o nome %s", lista.size(), p.getNome());
			if (lista.size() > 0) { 
				mv.addObject("petLista", lista);
			}
		}
		mv.addObject("MSG", msg);
		return mv;
	}
}
