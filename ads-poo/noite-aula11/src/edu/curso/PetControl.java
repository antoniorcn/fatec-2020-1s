package edu.curso;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PetControl {
	private PetDAO petDAO = new PetDAOImpl();
	private ObservableList<Pet> lista = FXCollections.observableArrayList();
	
	public PetControl() { 
	}

	private void alertError(String title, String header, String content) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}

	public void adicionar(Pet p) { 
		petDAO.adicionar(p);
	}

	public Pet pesquisarPorNome(String nome) { 
		lista.clear();
		List<Pet> pets = petDAO.pesquisarPorNome(nome);
		lista.addAll(pets);
		return lista.get(0);
	}

	public ObservableList<Pet> getLista() {
		return lista;
	}

}
