package edu.curso;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PetControl {
	private PetDAO petDAO = new PetDAOImpl();
	private ObservableList<Pet> lista = FXCollections.observableArrayList();
	private ObservableList<String> racas = 
			FXCollections.observableArrayList("Bulldog", "Cocker", "Fila", 
					"Pastor Alemão", "Pitbull", "Vira Lata");
	private Validator validator;
	
	public PetControl() { 
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	private void alert(AlertType tipo, String title, String header, String content) {
		Alert alert = new Alert(tipo);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}

	public void adicionar(Pet p) { 
		Set<ConstraintViolation<Pet>> erros = validator.validate(p);
		if (erros.isEmpty()) { 
			petDAO.adicionar(p);
			alert(AlertType.INFORMATION, "Pet Shop", null, 
					"Pet " + p.getNome() + " cadastrado com sucesso");
			pesquisarPorNome("");
		} else { 
			String msgErros = "Erros: \n";
			for (ConstraintViolation<Pet> erro : erros ) { 
				msgErros += erro.getPropertyPath() + " - " + erro.getMessage() + "\n";
			}
			alert(AlertType.ERROR, "Pet Shop", "ERRO: Não foi possivel cadastrar o pet", msgErros);
		}
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

	public ObservableList<String> getRacas() {
		return racas;
	}

}
