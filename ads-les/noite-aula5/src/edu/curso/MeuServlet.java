package edu.curso;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/meuservlet")
public class MeuServlet implements Servlet {
	private ServletConfig sc;
	@Override
	public void destroy() {
	}
	@Override
	public ServletConfig getServletConfig() {
		return sc;
	}
	@Override
	public String getServletInfo() {
		return "MeuServlet";
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		sc = config;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("Servlet foi acionado...");
	}
}
