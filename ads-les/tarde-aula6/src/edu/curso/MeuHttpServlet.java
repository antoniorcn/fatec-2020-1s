package edu.curso;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servico")
public class MeuHttpServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req,
			HttpServletResponse res) throws IOException { 
		this.processa(req, res);
	}
	
	@Override
	public void doPost(HttpServletRequest req,
			HttpServletResponse res) throws IOException { 
		
		this.processa(req, res);
	}
	
	public void processa(HttpServletRequest req,
			HttpServletResponse res) throws IOException { 
		PrintWriter out = res.getWriter();
		out.println("<h1>Você acessou este servlet</h1>");
//		Enumeration<String> headers = req.getHeaderNames();
//		while (headers.hasMoreElements()) {
//			String headerName = headers.nextElement();
//			out.print("<p>Cabeçalho: (" + headerName);
//			out.print(")Valor: " + req.getHeader(headerName) + "</p>");
//		}
		String ua = req.getHeader("user-agent");
		out.println("Você está acessando de um: " + ua);
	}

}
