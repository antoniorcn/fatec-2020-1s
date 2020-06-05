package edu.curso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TesteLista {
	
	public static void main(String[] args) {
		List<String> lista = new ArrayList<>();
		
		lista.add("A");
		lista.add("B");
		lista.add("D");
		lista.add("B");
		
		Collections.sort(lista);
		
		for (String s : lista) { 
			System.out.println(s);
		}
	}

}
