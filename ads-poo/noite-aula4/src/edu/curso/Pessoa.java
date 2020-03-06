package edu.curso;

public class Pessoa extends Animal {
	private String nome;
	public Pessoa(String n) {
		this.nome = n;
		System.out.println("Construindo Pessoa");
	}
}
