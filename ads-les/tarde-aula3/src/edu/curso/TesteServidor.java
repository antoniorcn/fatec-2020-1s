package edu.curso;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TesteServidor {
	private final static int PORTA = 6666; 
	private ServerSocket server;
	private Socket cliente;
	public TesteServidor() { 
		try {
			System.out.println("Iniciando servidor");
			server = new ServerSocket(PORTA);
			System.out.println("Servidor ativo, aguardando conexão");
			cliente = server.accept();
			OutputStream out = cliente.getOutputStream();
			out.write("Ola cliente bem vindo ao servidor\n\r".getBytes());
			out.write("Tudo o que vc digitar eu mostrarei na console".getBytes());
			out.flush();
			System.out.println("Cliente conectado");
			InputStream in = cliente.getInputStream();
			boolean sair = false;
			while (!sair) { 
				if (in.available() > 0) { 
					char c = (char)in.read();
					System.out.print(c);
					if ((int)c == 27) { 
						sair = true;
					}
				}
			}
			
			cliente.close();
		} catch(Exception e) { 
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new TesteServidor();
	}
}
