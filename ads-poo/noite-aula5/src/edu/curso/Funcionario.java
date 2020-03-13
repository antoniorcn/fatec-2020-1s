package edu.curso;

public class Funcionario {
	private String nome;
	public Funcionario(String nome) {
		this.nome = nome; 
	}
	public void recebePagamento(float f) {
		System.out.printf("Eba!!, eu %s recebi: %7.2f\n", nome, f);
		
	}
}
