package edu.curso;

import java.io.IOException;

public class TesteRuntime {

	public static void main(String[] args) throws IOException {
		Runtime.getRuntime().exec("calc.exe");
	}

}
