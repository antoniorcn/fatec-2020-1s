package edu.curso;

public class A {
	private int v;
	public A (int valor) {
		v = valor;
		System.out.println("Criando A");
	}
	
	public A() { 
		this(10);
	}

}
