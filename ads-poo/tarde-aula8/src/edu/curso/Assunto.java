package edu.curso;

public interface Assunto {
	void add(Observador o);
	void remove(Observador o);
	void notificar(String msg);
}
