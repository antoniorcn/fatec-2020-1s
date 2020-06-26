package edu.curso;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class TestePropertyJavaFX {
	
	public static void main(String[] args) {
		
		StringProperty texto = new SimpleStringProperty("Texto 1");		
		texto.addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, 
					String oldValue, String newValue) {
				System.out.printf("O texto mudou de: %s  para: %s\n", oldValue, newValue);			
			}
		});
		
		texto.set("Texto2");
		
		System.out.println(texto.get());
		
		
		
	}

}
