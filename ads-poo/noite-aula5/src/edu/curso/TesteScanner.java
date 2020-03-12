package edu.curso;

import java.util.Scanner;

public class TesteScanner {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Programa dados do usuário");
		System.out.println("Digite seu nome:");
		String nome = scan.nextLine();
		System.out.println("Digite sua idade:");
		int idade = scan.nextInt();
		System.out.println("Digite seu peso:");
		float peso = scan.nextFloat();
		// String strPeso = String.valueOf(peso);
		String strPeso = String.format("%6.3f", peso);
		System.out.println("Peso formatado: " + strPeso);
		scan.nextLine();
		System.out.println("Digite seu email:");
		String email = scan.nextLine();
		
		System.out.println("Bem vindo");
		System.out.println(nome);
		System.out.printf("Idade: %d \t Peso: %5.2f\n", idade, peso);
		System.out.println(email);
		scan.close();
	}

}
