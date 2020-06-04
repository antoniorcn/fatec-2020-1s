package edu.curso;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Pet {
	private String nome;
	private String raca;
	private LocalDate nascimento;
	
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
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	public LocalDate getNascimento() {
		return nascimento;
	}
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
}
