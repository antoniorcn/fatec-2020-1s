package edu.curso;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/petServlet")
public class PetServlet extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException { 
		super.init(config);
		List<Pet> lista = (List<Pet>)getServletContext().getAttribute("LISTA");
		if (lista == null) { 
			lista = new ArrayList<>();
			getServletContext().setAttribute("LISTA", lista);
			System.out.println("### Foi criada a lista na area de memoria ###");
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws IOException { 
		
		List<Pet> lista = (List<Pet>)getServletContext().getAttribute("LISTA");
		
		String nome = request.getParameter("NOME");
		String raca = request.getParameter("RACA");
		String nasc = request.getParameter("NASC");
		
		Pet p = new Pet();
		p.setNome(nome);
		p.setRaca(raca);
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate nascimento = LocalDate.parse(nasc, format);
		p.setNascimento(nascimento);
		
		lista.add(p);
		System.out.printf("Há %d pets na memoria\n", lista.size());
		
		String msg = String.format("O pet %s foi cadastrado com sucesso", nome);
		HttpSession session = request.getSession();
		session.setAttribute("MENSAGEM", msg);
		response.sendRedirect("./pet.jsp");
	}
	
}
