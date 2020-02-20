package edu.curso;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class LerObjeto {

	public static void imprimeLista(List<String> lista) { 
		for (String e : lista) { 
			System.out.println(e);
		}
	}
	
	public static List<String> lerListaArquivo(String nome) throws Exception { 
		File f = new File(nome);
		FileInputStream fin = new FileInputStream(f);
		ObjectInputStream objIn = new ObjectInputStream(fin);
		List<String> list = (List<String>)objIn.readObject();
		objIn.close();
		return list;
	}
	
	public static void main(String[] args) {
		try { 
			List<String> list = lerListaArquivo("C:/temp/lista.dat");
			System.out.println("Lista lida com sucesso");
			imprimeLista(list);
		} catch(Exception e) { 
			System.out.println("Erro ao ler a lista");
		}
	}

}
