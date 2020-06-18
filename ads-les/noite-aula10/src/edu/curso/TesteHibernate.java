package edu.curso;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class TesteHibernate {
	
	public static Aluno generateAluno(EntityManager em, String ra, String nome) { 
		Aluno a = new Aluno();
		a.setRa(ra);
		a.setNome(nome);
		
//		em.getTransaction().begin();
//		em.persist(a1);
//		em.getTransaction().commit();
		return a;
	}
	
	public static void consultaAluno(EntityManager em) { 
		// Aluno a1 = generateAluno("11111", "Antonio");
		
		Aluno a1 = em.find(Aluno.class, 0l);
		
		System.out.println("Ra: " + a1.getRa());
		System.out.println("Nome: " + a1.getNome());
		
//		em.getTransaction().begin();
//		a1.setNome("José Pedro");
//		em.getTransaction().commit();
		
	}
	
	public static void gerarAlunosSalas(EntityManager em) { 
		Aluno a1 = new Aluno("11111", "João");
		Aluno a2 = new Aluno("22222", "Maria");
		Aluno a3 = new Aluno("33333", "Olivia");
		Aluno a4 = new Aluno("44444", "Popeye");
		
		SalaAula s1 = new SalaAula("Matematica", "Cante");
		SalaAula s2 = new SalaAula("Portugues", "Ricardo");
		SalaAula s3 = new SalaAula("POO", "Antonio");
		SalaAula s4 = new SalaAula("BD I", "Satoshi");
		SalaAula s5 = new SalaAula("BD II", "Colevatti");
		
		a1.setSala(s1);
		a2.setSala(s1);
		
		a3.setSala(s2);
		a4.setSala(s2);
		
		em.getTransaction().begin();
		em.persist(a1);
		em.persist(a2);
		em.persist(a3);
		em.persist(a4);
		em.getTransaction().commit();
	}
	
	public static void lerSalas(EntityManager em) { 
		TypedQuery<SalaAula> qry = em.createQuery("select s from SalaAula s", SalaAula.class);
		List<SalaAula> salas = qry.getResultList();
		
		for (SalaAula s : salas) { 
			System.out.println("Nome: " + s.getNome());
			
			for (Aluno a : s.getAlunos()) { 
				System.out.println("RA:  " + a.getRa() + "  Nome: " + a.getNome());
			}
		}
	}

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TESTE");
		EntityManager em = emf.createEntityManager();
		System.out.println("**** Hibernate ativo ****");
		
		lerSalas(em);
		
		em.close();
		emf.close();
	}
}
