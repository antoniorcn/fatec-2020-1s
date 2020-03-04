package edu.curso;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Cliente {
	private static final String HOSTNAME    = "127.0.0.1";
	private static final int PORT = 6666;
	private Socket srv;
	public Cliente() { 
		try {
			System.out.println("Tentando se contectar no servidor");
			srv = new Socket(HOSTNAME, PORT);
			System.out.println("Conectado no servidor");
			InputStream in = srv.getInputStream();
			OutputStream out = srv.getOutputStream();
			int i = 0;
			while(i != 27) { 
				if (System.in.available() > 0) { 
					int tecla = System.in.read();
					out.write(tecla);
					out.flush();
				}
				if (in.available() > 0) { 
					i = in.read();
					System.out.print((char)i);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Cliente();
	}

}
