package edu.curso;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PetControl {
	private ObservableList<Pet> lista = FXCollections.observableArrayList();
	private ObservableList<String> racas = 
			FXCollections.observableArrayList(
					"Bulldog", "Cocker", "Pastor Alemão", "Poodle", "Vira Lata");
	
	PetDAO petDAO = new PetDAOImpl();
	
	public PetControl() { 
	}
	
	public void adicionar(Pet p) { 
		petDAO.adicionar(p);
		pesquisar("");
	}
	
	public void pesquisar(String nome) {
		lista.clear();
		List<Pet> listaTemp = petDAO.pesquisarPorNome(nome);
		lista.addAll(listaTemp);
	}
	
	public ObservableList<Pet> getLista() {
		return lista;
	}

	public ObservableList<String> getRacas() {
		return racas;
	}
}
