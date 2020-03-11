package edu.curso;

public class TesteOrdenacao {
	public static void main(String[] args) {
		Job j1 = new Job("A");
		Job j2 = new Job("B");
		Thread t1 = new Thread(j1);
		t1.start();
		
		Thread t2 = new Thread(j2);
		t2.start();
	}
}
