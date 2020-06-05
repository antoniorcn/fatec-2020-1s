package edu.curso;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class AlunoObservavel {
	private StringProperty nome = new SimpleStringProperty("");
	
	public String getNome() { 
		return nome.get();
	}
	public void setNome(String nome) { 
		this.nome.set(nome);
	}
	
	public AlunoObservavel() { 
		this.nome.addListener(new ChangeListener<String>() {
			@Override
			public void changed(
					ObservableValue<? extends String> prop, String antigo, String novo) {
				System.out.printf("Propriedade nome foi trocada de %s para o valor %s\n", antigo, novo);
			} 
		});
	}
	
	public static void main(String[] args) {
		AlunoObservavel a1 = new AlunoObservavel();
		a1.setNome("João");
		a1.setNome("Maria");
		
		System.out.println("Nome do aluno foi alterado");
	}

}
