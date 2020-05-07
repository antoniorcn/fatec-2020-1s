package edu.curso;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.google.gson.Gson;
@WebServlet("/generico")
public class Generico extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) 
			throws ServletException, IOException {
		Gson g = new Gson();
		
		String nome = req.getParameter("NOME");
		String especie = req.getParameter("ESPECIE");
		String raca = req.getParameter("RACA");
		
		Pet p1 = new Pet();
		p1.setId(3L);
		p1.setNome(nome);
		p1.setEspecie(especie);
		p1.setRaca(raca);
		p1.setPeso(5.0);
		
		String j = g.toJson(p1);
		System.out.println("Servlet Generico executado");
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		//out.println("<p><h1>Linha 1 de texto ...</h1>");
		//out.println("<h2>Do servlet Generico ...</h2></p>");
		out.println(j);
		out.flush();
		
	}
}
