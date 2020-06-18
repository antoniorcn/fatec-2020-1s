package edu.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PetControl {
	private static final String URL = "jdbc:mariadb://localhost/petshop?allowMultiQueries=true";
	private static final String USER = "root";
	private static final String PASS = "";
	private ObservableList<Pet> lista = FXCollections.observableArrayList();
	
	public PetControl() { 
	}
	
	public void adicionar(Pet p) { 
		lista.add(p);
		try {
			Connection con = DriverManager.getConnection(URL, USER, PASS);
//			Statement stmt = con.createStatement();
//			String sql = String.format("INSERT INTO pet (id, nome, raca, peso, nascimento) VALUES ("
//					+ "0, '%s', '%s', 18.5, '2018-04-03')", p.getNome(), p.getRaca());
			String sql = "INSERT INTO pet (id, nome, raca, peso, nascimento) "
					+ "VALUES (0, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getRaca());
			stmt.setDouble(3, p.getPeso());
			stmt.setDate(4,  java.sql.Date.valueOf(p.getNascimento()));
			
			System.out.println(sql);
			stmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Pet pesquisar(String nome) {
		try { 
			Connection con = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM pet WHERE nome like ?");
			stmt.setString(1, "%" + nome + "%");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) { 
				Pet p = new Pet();
				p.setId( rs.getLong("id") );
				p.setNome( rs.getString("nome") );
				p.setRaca( rs.getString("raca") );
				p.setPeso( rs.getDouble("peso") );
				p.setNascimento( rs.getDate("nascimento").toLocalDate() );
				return p;
				
			}
			con.close();
		} catch (Exception e) { 
			System.out.println("Erro ao ler do banco de dados");
		}
		return new Pet();
	}
	
	public ObservableList<Pet> getLista() {
		return lista;
	}
}
