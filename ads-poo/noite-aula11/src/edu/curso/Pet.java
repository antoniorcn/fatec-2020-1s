package edu.curso;

import java.time.LocalDate;

public class Pet implements Comparable<Pet> {
	private long id;
	private String nome = "";
	private String raca = "";
	private double peso;
	private LocalDate nascimento = LocalDate.now();
	
	public Pet() { 
		
	}
	
	public Pet(String nome) {
		this.nome = nome;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public LocalDate getNascimento() {
		return nascimento;
	}
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	@Override
	public int compareTo(Pet p) {
		return getNome().compareTo(p.getNome());
	}
	
	@Override
	public String toString() { 
		return nome;
	}
}
