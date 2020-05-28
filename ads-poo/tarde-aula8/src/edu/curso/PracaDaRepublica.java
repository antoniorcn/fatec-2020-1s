package edu.curso;

public class PracaDaRepublica {
	public static void main(String[] args) {
		Jornal jt = new Jornal("Jornal da Tarde");
		Jornal folha = new Jornal("Folha de São Paulo");
		
		Assinante joao = new Assinante("Joao");
		Assinante maria = new Assinante("Maria");
		Assinante paulo = new Assinante("Paulo");
		Assinante oscar = new Assinante("Oscar");
		Assinante tifany = new Assinante("Tifany");
		Assinante elizabeth = new Assinante("Elizabeth");
		
		jt.add(joao);
		jt.add(elizabeth);
		
		folha.add(maria);
		folha.add(paulo);
		folha.add(oscar);
		folha.add(tifany);
		
		jt.notificar("Governo do estado decreta fim da quarentena");
		
		folha.notificar("Oracle e IBM se fundem em uma empresa enorme");
	}
}

