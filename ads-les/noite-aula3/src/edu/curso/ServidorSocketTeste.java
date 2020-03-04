package edu.curso;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSocketTeste {
	public ServidorSocketTeste() throws IOException { 
		ServerSocket srv = new ServerSocket(3000);
		System.out.println("Servidor criado e aguardando conexão do cliente");
		Socket cliente = srv.accept();
		System.out.println("Cliente conectou com sucesso");
		cliente.close();
	}

	public static void main(String[] args) throws IOException {
		new ServidorSocketTeste();
	}

}
