package edu.curso;

public class Assinante implements Observador {
	private String nome;
	public Assinante(String nome) {
		this.nome = nome;
	}
	
	@Override
	public void update(String noticia) {
		System.out.println(this.nome + " esta lendo " + noticia);
	}
}
