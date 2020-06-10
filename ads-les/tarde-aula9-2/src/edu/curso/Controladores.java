package edu.curso;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controladores {
	
	@GetMapping("/t1")
	public String teste() { 
		System.out.println("### Controller acionado ###");
		return "teste";
	}

}
