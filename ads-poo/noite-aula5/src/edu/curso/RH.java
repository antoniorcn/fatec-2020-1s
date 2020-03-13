package edu.curso;

public class RH {
	public float salario = 2000f;
	public void fazPagamento(Funcionario f) {
		float inss = salario * 0.09f;
		f.recebePagamento(salario - inss);
	}

}
