package edu.curso;

public class Aluno {
	
	private String nome;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public static void main(String[] args) {
		Aluno a1 = new Aluno();
		a1.setNome("João");
		a1.setNome("Maria");
		
		System.out.println("Nomes do aluno alterado");
	}
	
	

}
