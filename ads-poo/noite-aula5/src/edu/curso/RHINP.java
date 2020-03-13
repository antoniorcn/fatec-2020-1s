package edu.curso;

public class RHINP extends RH {
	@Override
	public void fazPagamento(Funcionario f) { 
		float inss = salario * 0.09f;
		float vt = salario * 0.06f;
		f.recebePagamento(salario - vt - inss);
		
	}

}
