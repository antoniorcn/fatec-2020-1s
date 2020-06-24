package edu.curso;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Pet {
	
	private long id;
	private String nome;
	private String raca;
	private LocalDate nascimento = LocalDate.now();
	private boolean vacinaAntiRabica = false;
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(length=50)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(length=25)
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
	
	@Type(type="yes_no")
	public boolean isVacinaAntiRabica() {
		return vacinaAntiRabica;
	}
	public void setVacinaAntiRabica(boolean vacinaAntiRabica) {
		this.vacinaAntiRabica = vacinaAntiRabica;
	}
}
