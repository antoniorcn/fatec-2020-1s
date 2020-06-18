package edu.curso;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class TesteDB {
	private static final String URL = 
			"jdbc:mariadb://localhost:3306/petshop";
	private static final String USER = "root";
	private static final String PASS = "";
	public static void main(String[] args) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Classe Mariadb Connector carregada com sucesso");
			
			Connection con = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("Conexão foi feita com sucesso");
			String sql = "INSERT INTO pet (id, nome, raca, peso, nascimento) VALUES ("
					+ "0, 'Totó', 'bulldog', 17.8, '2019-04-03')";
			Statement stmt = con.createStatement();
			int i = stmt.executeUpdate(sql);
			
			System.out.println("Pet inserido com sucesso");
			System.out.println(i);
			
		} catch (ClassNotFoundException e) {
			System.out.println("Erro ao carregar o driver do banco de dados");
		} catch (SQLException e) { 
			System.out.println("Erro ao conectar no banco de dados");
		}
	}
}
