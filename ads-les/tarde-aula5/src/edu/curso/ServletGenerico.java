package edu.curso;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/generico")
public class ServletGenerico 
	extends GenericServlet {
	
	@Override
	public void service(ServletRequest req, 
							ServletResponse res) 
		throws ServletException, IOException {
		
		String d = req.getParameter("DATA");
		System.out.println("Data enviada: " + d);
		
		res.setContentType("text/html");
		
		PrintWriter out = res.getWriter();
		out.println("<h2>Ola Navegador, obrigado por executar o servlet genérico</h2>");
		out.println("<h3>Você informou a data: " + d + "</h3>");
		out.flush();
	}
}
