package edu.curso;

public class Empresa {
	public static void main(String[] args) {
		RH rh = new RHINP();
		Funcionario f1 = new Funcionario("Astolfinho");
		Funcionario f2 = new Funcionario("Geronimo");
		Funcionario f3 = new Funcionario("Dilma");
		Funcionario f4 = new Funcionario("Pepa");
		
		rh.fazPagamento(f1);
		rh.fazPagamento(f2);
		rh.fazPagamento(f3);
		rh.fazPagamento(f4);
	}
}
