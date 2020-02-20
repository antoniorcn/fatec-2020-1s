package edu.curso;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GravarArquivo {
	
	public static void main(String[] args) {	
		File f = new File("C:/tmp2/nome.txt");
		try {
			FileWriter fw = new FileWriter(f);
			fw.write("Antonio Rodrigues");
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
