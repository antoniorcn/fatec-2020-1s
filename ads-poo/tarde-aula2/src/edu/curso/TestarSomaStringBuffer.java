package edu.curso;
public class TestarSomaStringBuffer {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		StringBuffer texto = new StringBuffer("");
		for (int i = 0; i < 20000; i++) { 
			texto.append(", " + i);
		}
		System.out.println(texto.toString());
		long endTime = System.currentTimeMillis();
		long dif = endTime - startTime;
		System.out.printf("Demorou %d milisegundos \n", dif);
	}
}
