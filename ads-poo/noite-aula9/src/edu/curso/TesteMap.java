package edu.curso;

import java.util.HashMap;
import java.util.Map;

public class TesteMap {
	
	public static void main(String[] args) {
		Map<String, Pet> mapa = new HashMap<>();
		
		Pet p1 = new Pet("Bidu");
		Pet p2 = new Pet("Rex");
		Pet p3 = new Pet("Lassie");
		
		mapa.put("B", p1);
		mapa.put("R", p2);
		mapa.put("L", p3);
		
		System.out.println( mapa.get("B").getNome() );
		
		System.out.println(mapa.keySet());
		System.out.println(mapa.values());
	}

}
