package edu.curso;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Aluno {
	private long id;
	private String nome = "";
	private String ra = "";
	private LocalDate nascimento = LocalDate.now();
	private String cpf;
	private SalaAula sala;
	
	public Aluno(String ra, String nome) { 
		this.ra = ra;
		this.nome = nome;
	}
	
	public Aluno() { 
		
	}
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(length=100)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(length=10)
	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
	}
	
	public LocalDate getNascimento() {
		return nascimento;
	}
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	
	@Column(length=13)
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@ManyToOne(cascade=CascadeType.PERSIST)
	public SalaAula getSala() {
		return sala;
	}
	public void setSala(SalaAula sala) {
		this.sala = sala;
	}
}
