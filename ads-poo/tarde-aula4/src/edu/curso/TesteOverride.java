package edu.curso;

public class TesteOverride {

	public static void main(String[] args) {
		RHCapitalista rh = new RHCapitalista();
		
		Funcionario f1 = new Funcionario();
		Gerente g1 = new Gerente();
		Diretor d1 = new Diretor();
		
		rh.fazPagamento(f1);
		rh.fazPagamento(g1);
		rh.fazPagamento(d1);
		rh.relatorio();
	}
}
