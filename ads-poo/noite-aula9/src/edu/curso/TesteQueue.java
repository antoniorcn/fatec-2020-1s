package edu.curso;

import java.util.ArrayDeque;
import java.util.Queue;

public class TesteQueue {
	
	public static void main(String[] args) {
		
		Queue<String> baralho = new ArrayDeque<>(); 
		
		Queue<String> jogador1 = new ArrayDeque<>(); 
		
		baralho.add("A");
		baralho.add("2");
		baralho.add("3");
		baralho.add("4");
		baralho.add("5");
		baralho.add("6");
		baralho.add("7");
		baralho.add("8");
		baralho.add("9");
		baralho.add("10");
		baralho.add("J");
		baralho.add("Q");
		baralho.add("K");


		System.out.println(baralho);
		
		String carta1 = baralho.poll();
		String carta2 = baralho.peek();
		System.out.println("Retirei a carta 1-" + carta1);
		System.out.println("Retirei a carta 2-" + carta2);
		System.out.println(baralho);
		
		
		jogador1.add(baralho.poll());
		
		System.out.println("Baralho: " + baralho);
		System.out.println("Jogador 1: " + jogador1);
		
	}

}
