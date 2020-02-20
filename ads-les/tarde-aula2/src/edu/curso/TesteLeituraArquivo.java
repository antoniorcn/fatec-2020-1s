package edu.curso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TesteLeituraArquivo {

	public static void main(String[] args) {
		File f = new File("C:/Windows/DirectX.log");
		
		System.out.println("Existe: " + f.exists());
		System.out.println("Pode Ler: " + f.canRead());
		System.out.println("Pode Gravar: " + f.canWrite());
		
		try {
			FileReader fr = new FileReader(f);
			int i = 0;
			while ((i = fr.read()) != -1) {
				// i = fr.read();
				// System.out.println(i);
				// if (i != -1) {
					System.out.print((char)i);
				// }
			}
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
