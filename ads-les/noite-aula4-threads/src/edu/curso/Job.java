package edu.curso;

import java.util.Random;

public class Job implements Runnable{
	public static final int TAMANHO = 10000;
	int vetor[] = {6, 5, 1, 3, 2, 4, 0};
	private String nome; 
	public Job(String n) { 
		this.nome = n;
		Random rnd = new Random();
		vetor = new int[TAMANHO];
		for (int i = 0; i < TAMANHO; i++) { 
			vetor[i] = rnd.nextInt();
		}
	}
	@Override
	public void run() {
		System.out.println(nome + " - Ordenando");
		for(int i = 0; i < vetor.length; i++) { 
			for (int j = 0; j < vetor.length - 1; j++) { 
				if (vetor[j] > vetor[j + 1]) { 
					int temp = vetor[j + 1];
					vetor[j + 1] = vetor[j];
					vetor[j] = temp;
				}
			}
			float porcentagem = i  * 100 / vetor.length;
			System.out.printf("%s - executando %6.2f%%\n", nome, porcentagem);
		}
		StringBuffer sb = new StringBuffer(nome + " - Ordenação concluída\n");
//		for( int i : vetor) { 
//			sb.append(i + ", ");
//		}
		System.out.println(sb.toString());
	}
}
