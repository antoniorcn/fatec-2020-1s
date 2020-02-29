package edu.curso;

import java.util.ArrayList;
import java.util.List;

public class EstourarMemoriaHeap {
	
	int[] vetor = new int[20000];
	EstourarMemoriaHeap proximo;
	
	
	public static void main(String args[]) throws InterruptedException {
		System.out.println("Tentando estourar a memoria Heap");
		EstourarMemoriaHeap raiz = new EstourarMemoriaHeap();
		EstourarMemoriaHeap ultimo = raiz;
		while (true) {  
			ultimo.proximo = new EstourarMemoriaHeap();
			ultimo = ultimo.proximo;
			
			Thread.sleep(1);
		}
	}
	

}
