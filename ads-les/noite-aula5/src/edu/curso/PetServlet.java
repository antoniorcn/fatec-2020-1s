package edu.curso;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/pet")
public class PetServlet extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) 
			throws ServletException, IOException {
		String n = req.getParameter("NOME");
		String e = req.getParameter("ESPECIE");
		String r = req.getParameter("RACA");
		
		res.setContentType("text/html");
		
		PrintWriter out = res.getWriter();
		out.println("<h1>Pet cadastrado</h1>");
		out.printf("<h3>O %s de raça %s de nome %s"
				+ " foi cadastrado com sucesso</h3>\n", e, r, n);
		out.flush();
	}
}
