package edu.curso;

import java.util.ArrayList;
import java.util.List;

public class Jornal implements Assunto {
	private String nome;
	public Jornal(String nome) {
		this.nome = nome; 
	}
	
	private List<Observador> lista = new ArrayList<>();
	@Override
	public void add(Observador o) {
		lista.add(o);
	}

	@Override
	public void remove(Observador o) {
		lista.remove(o);
	}

	@Override
	public void notificar(String msg) {
		System.out.println("Extra Extra ... Jornal " + this.nome + " divulga " + msg );
		for (Observador o : lista) { 
			o.update(msg);
		}
	}

}
