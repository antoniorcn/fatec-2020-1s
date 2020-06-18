package edu.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PetControl {
	private static final String URL = "jdbc:mariadb://localhost/petshop";
	private static final String USER = "root";
	private static final String PASS = "";
	private ObservableList<Pet> lista = FXCollections.observableArrayList();
	
	public PetControl() { 
		/* ListChangeListener ouvinte = new ListChangeListener() {
			@Override
			public void onChanged(Change c) {
				System.out.println("Modificação feita na lista");
			}
		};
		lista.addListener(ouvinte); */
	}
	
	public void adicionar(Pet p) { 
		// lista.add(p);
		try {
			Connection con = DriverManager.getConnection(URL, USER, PASS);
			Statement stmt = con.createStatement();
			String sql = String.format("INSERT INTO pet (id, nome, raca, peso, nascimento) VALUES ("
					+ "0, '%s', '%s', 18.5, '2018-04-03')", p.getNome(), p.getRaca());
			System.out.println(sql);
			stmt.executeUpdate(sql);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Pet pesquisar(String nome) { 
		for (Pet p : lista) { 
			if (p.getNome().contains(nome)) { 
				return p;
			}
		}
		return null;
	}
	
	public ObservableList<Pet> getLista() {
		return lista;
	}
}
