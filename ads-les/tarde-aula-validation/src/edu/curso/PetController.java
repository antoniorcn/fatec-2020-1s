package edu.curso;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
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
	public ModelAndView processaPet(@Valid Pet p, BindingResult result, ModelAndView mv, @RequestParam("cmd") String cmd) {
		String msg = null;
		System.out.printf("Há erros: %s \n", String.valueOf(result.hasErrors()));
		if ("adicionar".equals(cmd)) {
			if (!result.hasErrors()) { 
				petRepository.save(p);
				mv.addObject("PET", new Pet());
				msg = String.format("Pet %s foi adicionado com sucesso", p.getNome());
			} else { 
				mv.addObject("PET", p);
				msg = String.format("Erro ao gravar o pet %s", p.getNome());
			}
			
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
