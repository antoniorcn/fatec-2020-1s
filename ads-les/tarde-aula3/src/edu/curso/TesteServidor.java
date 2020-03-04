package edu.curso;

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
			byte[] bytes = "Ola cliente como você vai ?".getBytes();
			out.write(bytes);
			out.flush();
			System.out.println("Cliente conectado");
			cliente.close();
		} catch(Exception e) { 
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new TesteServidor();
	}
}
