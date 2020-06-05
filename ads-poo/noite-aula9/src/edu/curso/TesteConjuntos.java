package edu.curso;

import java.util.Set;
import java.util.TreeSet;

public class TesteConjuntos {

	public static void main(String[] args) {
		Pet bidu = new Pet("Bidu");
		Set<Pet> conjunto = new TreeSet<>();
		conjunto.add(new Pet("Toto"));
		conjunto.add(new Pet("Rex"));
		conjunto.add(new Pet("Lassie"));
		conjunto.add(bidu);
		conjunto.add(bidu);
		
		if (conjunto.contains(bidu)) { 
			System.out.println("Bidu esta no conjunto");
		}
		
		
		for (Pet p : conjunto) { 
			System.out.println(p.getNome());
		}

	}

}
