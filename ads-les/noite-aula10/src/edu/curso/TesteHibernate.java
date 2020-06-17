package edu.curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteHibernate {
	
	public static Aluno generateAluno(String ra, String nome) { 
		Aluno a = new Aluno();
		a.setRa(ra);
		a.setNome(nome);
		return a;
	}

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TESTE");
		EntityManager em = emf.createEntityManager();
		System.out.println("**** Hibernate ativo ****");
		
		Aluno a1 = generateAluno("11111", "Antonio");
		
		em.getTransaction().begin();
		em.persist(a1);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
