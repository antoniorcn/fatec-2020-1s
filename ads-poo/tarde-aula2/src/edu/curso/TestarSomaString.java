package edu.curso;

public class TestarSomaString {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		String texto = "";
		for (int i = 0; i < 20000; i++) { 
			texto = texto + ", " + i;
		}
		System.out.println(texto);
		long endTime = System.currentTimeMillis();
		long dif = endTime - startTime;
		System.out.printf("Demorou %d milisegundos \n", dif);
	}

}
