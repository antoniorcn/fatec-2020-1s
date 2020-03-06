package edu.curso;

public class RH {
	
	protected static double total = 0;
	
	public void fazPagamento(Funcionario f) { 
		f.receberSalario(1000);
		total += 1000;
	}
	
	public void relatorio() { 
		System.out.println("Total Gasto: " + total);
	}

}
