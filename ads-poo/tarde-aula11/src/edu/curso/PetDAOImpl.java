package edu.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetDAOImpl implements PetDAO {
	
	@Override
	public void adicionar(Pet p) {
		try {
			Connection con = DBConnectionSingleton.getInstance().getConnection();
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
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Pet> pesquisarPorNome(String nome) {
		List<Pet> lista = new ArrayList<>();
		try { 
			Connection con = DBConnectionSingleton.getInstance().getConnection();
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
				lista.add(p);
				
			}
			con.close();
		} catch (Exception e) { 
			System.out.println("Erro ao ler do banco de dados");
		}
		return lista;
	}

}
