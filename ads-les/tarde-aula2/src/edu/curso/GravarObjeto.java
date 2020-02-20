package edu.curso;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class GravarObjeto {

	private static List<String> lista = new ArrayList<>();

	public static void popularLista() { 
		lista.add("Joao");
		lista.add("Alberto");
		lista.add("Maria");
		lista.add("Fabio");
		lista.add("Sara");
	}

	public static void gravarLista(String arquivo) throws Exception { 
		File f = new File(arquivo);
		System.out.println("Existe: " + f.exists());
		System.out.println("Pode Gravar: " + f.canWrite());

		FileOutputStream fout = new FileOutputStream(f);
		ObjectOutputStream objOut = new ObjectOutputStream(fout);
		objOut.writeObject(lista);
		objOut.close();
	}

	public static void main(String[] args) {
		popularLista();
		try {
			gravarLista("C:/temp/lista.dat");
			System.out.println("Arquivo gravado com sucesso");
		} catch (Exception e) {
			System.out.println("Erro ao gravar o arquivo");
		}
	}
}
