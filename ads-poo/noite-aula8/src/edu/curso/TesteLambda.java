package edu.curso;

public class TesteLambda {
	
	public static void teste( InterfaceCom1Funcao i ) { 
		System.out.println("Objeto recebido");
		i.fazAlgo("Texto", 1);
	}

	public static void main(String[] args) {
	
		
		
		InterfaceCom1Funcao i = new InterfaceCom1Funcao() {
			@Override
			public void fazAlgo(String s, int i) {
				System.out.println("Teste 1: " + s);
			}
		};
		
		teste(i);
		
		teste( (s, n) -> {  
			System.out.println("Teste 2: " + s);
		});

	}

}
