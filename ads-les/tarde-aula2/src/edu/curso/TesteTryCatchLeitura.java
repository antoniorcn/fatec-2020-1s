package edu.curso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TesteTryCatchLeitura {
	
	public static void fazLeituraArquivo(String nome) 
			throws Exception { 
		File f = new File(nome);
		
		FileReader fr = new FileReader(f);
		int i = 0;
		while ((i = fr.read()) != -1) {
			System.out.print((char)i);
		}
		fr.close();
		
	}
	
	public static void main(String[] args) {
		System.out.println("Lendo arquivo");
		try {
			fazLeituraArquivo("C:/Windows/DirectX.log");
		} catch (Exception e) {
			System.out.println("Arquivo inexistente ou Erro ao ler o arquivo");
		}
	}
}
