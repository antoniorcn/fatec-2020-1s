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
		String strNum = req.getParameter("NUMERO");
		int numero = 7;
		if (strNum != null 
				&& strNum.chars()
				.allMatch(Character::isDigit)
			) { 
			numero = Integer.parseInt(strNum);
		}
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		
		for (int i = 0; i <= 10; i++)  { 
			int resultado = numero * i;
			out.printf("<h2>%d X %d = %d</h2>", numero, i, resultado);
		}
	}
}
