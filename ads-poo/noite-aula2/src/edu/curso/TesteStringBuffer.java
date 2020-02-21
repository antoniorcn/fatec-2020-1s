package edu.curso;

public class TesteStringBuffer {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		String texto = "";
		for(int i = 0; i < 30000; i++) { 
			texto += i + ", ";
		}
		long endTime = System.currentTimeMillis();
		long diff1 = endTime - startTime;

		
		long startTime1 = System.currentTimeMillis();
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < 30000; i++) { 
			sb.append(i + ", ");
		}
		long endTime1 = System.currentTimeMillis();
		long diff2 = endTime1 - startTime1;

		System.out.println("String normal");
		// System.out.println(texto);
		System.out.printf("Foram gastos %d milisegundos\n", diff1);
		
		System.out.println("StringBuffer");
		// System.out.println(sb.toString());
		System.out.printf("Foram gastos %d milisegundos\n", diff2);
		
		
		

	}

}
