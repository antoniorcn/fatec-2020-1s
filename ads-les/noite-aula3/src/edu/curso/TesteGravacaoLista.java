package edu.curso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TesteGravacaoLista {
	public static void main(String[] args)
			throws Exception {
		String textos[] = {"João", "Alberto", 
				"Maria", "Cleuza"};
		List<String> nomes          = Arrays.asList(textos);
		File f = new File("C:/temp/tmp2/lista.dat");
		FileOutputStream fout = new FileOutputStream(f);
		ObjectOutputStream objOut = 
				new ObjectOutputStream(fout);
		objOut.writeObject(nomes);
		objOut.close();
	}
}
