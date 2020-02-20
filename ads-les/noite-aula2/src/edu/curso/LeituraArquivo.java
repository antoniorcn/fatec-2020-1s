package edu.curso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeituraArquivo {

	public static void main(String[] args) {
		File f = new File("C:/tmp2/nome.txt");
		try {
			FileReader fr = new FileReader(f);
			int i = 0;
//			while( i != -1) {
//				i = fr.read();
//				if (i != -1) { 
//					System.out.print((char)i);
//				}
//			}
			while( (i = fr.read()) != -1) { 
				System.out.print((char)i);
			}
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
