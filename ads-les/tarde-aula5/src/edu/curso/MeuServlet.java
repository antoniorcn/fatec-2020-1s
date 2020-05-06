package edu.curso;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/meuservlet")
public class MeuServlet implements Servlet {
	private ServletConfig config;
	@Override
	public void destroy() {
	}
	@Override
	public ServletConfig getServletConfig() {
		return config;
	}
	@Override
	public String getServletInfo() {
		return "Servlet: " + MeuServlet.class.getName();
	}
	@Override
	public void init(ServletConfig cfg) throws ServletException {
		this.config = cfg;
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("Servlet acionado");
		System.out.println(new Date());
	}
}
