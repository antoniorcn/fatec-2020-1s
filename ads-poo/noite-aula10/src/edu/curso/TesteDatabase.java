package edu.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteDatabase {
	private static final String URL = "jdbc:mariadb://localhost:3306/petshop";
	private static final String USER = "root";
	private static final String PASS = "";
	public static void main(String[] args) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Classe carregada com sucesso");
			Connection con = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("Conex�o criada");
			
//			Statement stm = con.createStatement();
//			String sql = "INSERT INTO pet (id, nome, raca, peso, nascimento) "
//					+ "VALUES (0, 'Tot�', 'ViraLata', 14.5, '2014-05-07')";
//			int i = stm.executeUpdate(sql);
//			System.out.println("Linhas afetadas: " + i);
			
			PreparedStatement stm = con.prepareStatement("SELECT * FROM pet");
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				String nome = rs.getString("nome");
				String raca = rs.getString("raca");
				System.out.println("Nome: " + nome + "  Ra�a: " + raca);
			}
			
			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Problema ao carregar a classe do banco de dados");
		} catch (SQLException e) { 
			System.out.println("Erro ao conectar no banco de dados");
		}
	}
}
