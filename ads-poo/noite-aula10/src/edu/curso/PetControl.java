package edu.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PetControl {
	private static final String URL = "jdbc:mariadb://localhost/petshop?allowMultiQueries=true";
	private static final String USER = "root";
	private static final String PASS = "";

	public PetControl() { 
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			alertError("Erro de database", "Erro ao carregar a classe JDBC", e.getMessage());
		}
	}

	private void alertError(String title, String header, String content) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}

	public void adicionar(Pet p) { 
		try {
			Connection con = DriverManager.getConnection(URL, USER, PASS);
			String sql = "INSERT INTO pet (id, nome, raca, peso, nascimento) "
					+ "VALUES  (0, ?, ?, ?, ?)";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, p.getNome());
			stm.setString(2, p.getRaca());
			stm.setDouble(3, p.getPeso());
			stm.setDate(4, java.sql.Date.valueOf(p.getNascimento()));
			stm.executeUpdate();
			
//		    Statement stm = con.createStatement();
//  
// 			String sql = "INSERT INTO pet (id, nome, raca, peso, nascimento) " + 
//			"VALUES (0, '" + p.getNome()  + 
//			"', '" + p.getRaca() + 
//			"', " + p.getPeso()  + 
//			", '" + dtf.format(p.getNascimento()) + "')";
// 			stm.executeUpdate(sql); 
			
			
			con.close();
		} catch (SQLException e) {
			alertError("Erro de database", "Erro ao acessar o banco de dados", e.getMessage());
		}
	}

	public Pet pesquisarPorNome(String nome) { 
		try {
			Connection con = DriverManager.getConnection(URL, USER, PASS);
			String sql = "SELECT * FROM pet WHERE nome like ?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, "%" + nome + "%");
			ResultSet rs = stm.executeQuery();
			if (rs.first()) { 
				Pet p = new Pet();
				p.setNome(rs.getString("nome"));
				p.setRaca(rs.getString("raca"));
				p.setPeso(rs.getDouble("peso"));
				p.setNascimento(rs.getDate("nascimento").toLocalDate());
				return p;
			}
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
