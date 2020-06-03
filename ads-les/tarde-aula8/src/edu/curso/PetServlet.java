package edu.curso;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/petServlet")
public class PetServlet extends HttpServlet {	
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException { 
		List<Pet> lista = (List<Pet>)getServletContext().getAttribute("LISTA");
		if (lista == null) { 
			System.out.println("### Criando a lista ###");
			lista = new ArrayList<>();
			getServletContext().setAttribute("LISTA", lista);			
		}
		
		String nome = req.getParameter("nome");
		String raca = req.getParameter("raca");
		String nascimento = req.getParameter("nascimento");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Pet p = new Pet();
		p.setNome(nome);
		p.setRaca(raca);
		p.setNascimento(LocalDate.parse(nascimento, formatter));
		
		lista.add(p);
		System.out.printf("Há %d pets na lista\n", lista.size());
	}

}
