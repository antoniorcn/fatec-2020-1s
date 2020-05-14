package edu.curso;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servico")
public class MeuSevlet extends HttpServlet {
	public void doGet(HttpServletRequest req,
			HttpServletResponse res) throws IOException { 
		PrintWriter out = res.getWriter();
		out.println("<h1>Teste de Servlet</h1>");
	}
}
