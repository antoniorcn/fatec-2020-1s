package edu.curso;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/tabuada")
public class Tabuada extends HttpServlet {
	public void doGet(HttpServletRequest req, 
			HttpServletResponse res) throws IOException {
		processar(req, res);
	}
	
	public void doPost(HttpServletRequest req, 
	HttpServletResponse res) throws IOException {
		processar(req, res);
	}
	
	public void processar(HttpServletRequest req, 
			HttpServletResponse res) throws IOException { 
		String strNum = req.getParameter("NUMERO");
		int numero = 7;
		if (strNum != null) {
			numero = Integer.parseInt(strNum);
		}
		
		PrintWriter out = res.getWriter();
		for (int i = 0; i <= 10; i++) { 
			int resposta = numero * i;
			out.printf("<p>%d X %d = %d</p>\n", numero, i, resposta);
		}
	}
}
