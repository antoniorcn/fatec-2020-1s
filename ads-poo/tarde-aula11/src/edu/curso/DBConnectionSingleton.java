package edu.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionSingleton {
	private static final String URL = "jdbc:mariadb://localhost/petshop?allowMultiQueries=true";
	private static final String USER = "root";
	private static final String PASS = "";
	private static DBConnectionSingleton instancia;
	private Connection con;
	
	private DBConnectionSingleton() { 
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static DBConnectionSingleton getInstance() { 
		if (instancia == null) { 
			instancia = new DBConnectionSingleton();
			System.out.println("Nova conexão no banco gerada");
		}
		return instancia;
	}
	
	public Connection getConnection() { 
		try { 
			if (con == null || !con.isValid(2)) { 
				con = DriverManager.getConnection(URL, USER, PASS);
			}
			return con;
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return null;
	}

}
