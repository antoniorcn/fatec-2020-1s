package edu.curso;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PetControl {
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
		lista.add(p);
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
