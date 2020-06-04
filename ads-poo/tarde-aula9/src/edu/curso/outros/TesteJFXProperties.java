package edu.curso.outros;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class TesteJFXProperties {
	
	private StringProperty nome = new SimpleStringProperty();
	public String getNome() { 
		return nome.get();
	}
	public void setNome(String nome) { 
		this.nome.set(nome);
	}
	
	public TesteJFXProperties() { 
		ChangeListener<String> objOuvinte = new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> prop, String velho, String novo) {
				System.out.printf("A propriedade %s esta sendo mudada de %s para %s\n",
						"Nome", velho, novo);
				
			}
			
		};
		
		this.nome.addListener(objOuvinte);
	}
	
	public void executar() { 
		System.out.println("Alterando as propriedades");
		setNome("Antonio");
		setNome("João");
	}
	
	public static void main(String[] args) {
		TesteJFXProperties teste = new TesteJFXProperties();
		teste.executar();
	}

}
