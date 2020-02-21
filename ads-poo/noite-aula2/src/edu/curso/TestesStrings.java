package edu.curso;

public class TestesStrings {

	public static void main(String[] args) {
		String a = "Antonio";
		String b = a;
		b = b + "";
		System.out.println("A: " + a);
		System.out.println("B: " + b);
		if (a == b) { 
			System.out.println("Iguais");
		} else { 
			System.out.println("Diferentes");
		}
	}
}
