package edu.curso;

public class TesteStrings {
	public static void main(String[] args) {
		String a = "Antonio";
		String b = "Antonio";
		b = b + "";
		System.out.println("A: " + a);
		System.out.println("B: " + b);
		if (a == b) { 
			System.out.println("São Iguais");
		} else { 
			System.out.println("São Diferentes");
		}
	}
}
