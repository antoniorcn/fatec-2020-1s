package edu.curso;

public class Funcionario {
	
	float salario;
	
	Funcionario(float salario) { 
		this.salario = salario;
	}
	
	Funcionario() { 
		this.salario = 1500.00f;
	}
	
	public void impostos(float[] federais, float[] estaduais) { 
		for(float imposto : federais) {
			salario -= imposto;
		}
		
		for(float imposto : estaduais) {
			salario -= imposto;
		}
	}
	
	public void adicionarBeneficios(float ... beneficios) { 
	// public void adicionarBeneficios(float[] beneficios) {
		for (int i = 0; i < beneficios.length; i++) {
			salario += beneficios[i];
		}
	}
	
	public static void main(String[] args) {
		Funcionario alfredo = new Funcionario(3000);
		// alfredo.adicionarBeneficios(new float[] {100, 150, 30, 80, 12, 3.5f});
		alfredo.adicionarBeneficios(null);
		alfredo.impostos(null, new float[] {100});
		System.out.println(alfredo.salario);
	}

}
