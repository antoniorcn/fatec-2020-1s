package edu.curso;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TesteServidorComandos {
	private final static int PORTA = 6666; 
	private ServerSocket server;
	private Socket cliente;
	public TesteServidorComandos() { 
		try {
			System.out.println("Iniciando servidor");
			server = new ServerSocket(PORTA);
			System.out.println("Servidor ativo, aguardando conexão");
			cliente = server.accept();
			OutputStream out = cliente.getOutputStream();
			out.write("Ola cliente bem vindo ao servidor de comandos\n\r".getBytes());
			out.write("Tudo o que vc digitar eu executarei na maquina servidora".getBytes());
			out.flush();
			System.out.println("Cliente conectado");
			InputStream in = cliente.getInputStream();
			InputStreamReader r = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(r);
			boolean sair = false;
			while (!sair) { 
				if (br.ready()) { 
					String linha = br.readLine();
					if ("sair".equalsIgnoreCase(linha)) { 
						sair = true;
					} else {
						System.out.println("Executando comando: " + linha);
						Runtime.getRuntime().exec(linha);
						
					}
				}
			}
			cliente.close();
		} catch(Exception e) { 
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new TesteServidorComandos();
	}
}
