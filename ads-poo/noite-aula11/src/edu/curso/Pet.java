package edu.curso;

import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

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
	
	@NotBlank
	@Size(min=2, max=50)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@NotBlank
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	
	@DecimalMin(value="0.5", message = "o peso minimo aceitável é de 1/2Kg")
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	@PastOrPresent(message = "esta data deve estar no passado")
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
