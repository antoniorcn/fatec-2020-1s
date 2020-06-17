package edu.curso;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Pet {
	
	private long id;
	private String nome;
	private String raca;
	private LocalDate nascimento = LocalDate.now();
	
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
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public LocalDate getNascimento() {
		return nascimento;
	}
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
}
