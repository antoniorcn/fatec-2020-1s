package edu.curso;

import java.util.Queue;
import java.util.Stack;

public class RHCapitalista extends RH {
	@Override
	public void fazPagamento(Funcionario f) { 
		f.receberSalario(2000);
		total += 2000;
		
	}

}
