package edu.curso;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	public boolean consultaLogin(String usuario) {
		try { 
			final String DRIVER = "org.mariadb.jdbc.Driver";
			final String URL = "jdbc:mariadb://localhost:3306/teste_login";
			final String USER = "root";
			final String PASS = "";
			Class.forName(DRIVER); //com.mysql.jdbc.Driver
			System.out.println("Classe carregada");
			Connection con = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("Conectado com o banco de dados");
			String sql = "SELECT * FROM tbl_usuarios WHERE usuario = ?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, usuario);
			ResultSet rs = stm.executeQuery();
			return rs.first();
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
//		PrintWriter out = res.getWriter();
//		res.setContentType("text/html");
//		out.println("<h2>Para fazer o login acesse a <a href='./login.html'>página de login</a></h2>");

//		res.sendRedirect("http://www.uol.com.br");
		res.sendRedirect("./login.html");
		
//		PrintWriter out = res.getWriter();
//		res.setContentType("text/html");
//		out.println("<body><script>location.href = 'http://drive.google.com';</script></body>");

	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException { 
		String txtLogin = req.getParameter("TXTLOGIN");
		String txtSenha = req.getParameter("TXTSENHA");
		
		PrintWriter out = res.getWriter();
		
		boolean r = consultaLogin(txtLogin);
		if (r) { 
			out.println("<h1>Usuario autenticado com sucesso</h1>");
		} else { 
			out.println("<h1>Usuario não existe</h1>");
		}
	}

}
