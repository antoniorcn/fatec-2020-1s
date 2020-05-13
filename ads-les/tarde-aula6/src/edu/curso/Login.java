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
@WebServlet("/login")
public class Login extends HttpServlet{
	
	public boolean consultaLogin(String user) {
		final String DRIVER = "org.mariadb.jdbc.Driver";
		final String URL = "jdbc:mariadb://localhost:3306/teste_login";
		final String USER = "root";
		final String PASS = "";
		
		try {
			Class.forName(DRIVER);
			Connection con = 
					DriverManager.getConnection(URL, USER, PASS);
			String sql = "SELECT * FROM tbl_usuarios "
					+ "WHERE usuario = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, user);
			ResultSet rs = stmt.executeQuery();
			boolean r = rs.first();
			con.close();
			return r;
		} catch(Exception e) { 
			System.out.println("Erro ao acessar o banco");
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public void doGet(HttpServletRequest req, 
			HttpServletResponse res) throws IOException { 
		String user = req.getParameter("TXTUSER");
		String pass = req.getParameter("TXTPASS");
		PrintWriter out = res.getWriter();
		if (this.consultaLogin(user)) { 
			out.println("<h1>Usuario autenticado</h1>");
		} else {
			out.println("<h1>Usuario inexistente</h1>");
		}
	}
}
