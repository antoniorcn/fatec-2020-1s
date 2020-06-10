package edu.curso;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TesteConsulta {
	
	public static void adicionarConsultas(EntityManager em) { 
		TypedQuery<Pet> qry = 
				em.createQuery("Select p from Pet p", Pet.class);
		List<Pet> pets = qry.getResultList();
		
		Consulta c1 = new Consulta();
		c1.setData(LocalDate.now());
		c1.setDescricao("Meu bichinho esta fedido");
		c1.setId(0);
		c1.setVeterinario("Dr. Pimpolho");
		c1.getPets().add(pets.get(4));
		
		Consulta c2 = new Consulta();
		c2.setData(LocalDate.now());
		c2.setDescricao("Ele não quer beber água");
		c2.setId(0);
		c2.setVeterinario("Dr. Pimpolho");
		c2.getPets().add(pets.get(1));
		
		em.getTransaction().begin();
		em.persist(c1);
		em.persist(c2);
		em.getTransaction().commit();
	}
	
	public static void listarConsultas(EntityManager em) { 
		TypedQuery<Consulta> qry =
				em.createQuery("select c from Consulta c", Consulta.class);
		List<Consulta> consultas = qry.getResultList();
		for (Consulta c : consultas) { 
			System.out.printf("Data: %s   Veterinario: %s\n", c.getData(), c.getVeterinario());
		}
	}
	
	public static void listarConsultasPorPet(EntityManager em, long idPet) { 
		Pet p = em.find(Pet.class, idPet);
		System.out.printf("O pet %s fez as seguintes consultas: \n", p.getNome());
		for (Consulta c : p.getConsultas()) {
			System.out.printf("Data: %s   Veterinario: %s\n", c.getData(), c.getVeterinario());
		}
	}
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PET");
		EntityManager em = emf.createEntityManager();
		Pet p = new Pet();
		p.setNome("Princesa");
		p.setNascimento(LocalDate.now());
		
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		System.out.println("Pet cadastrado com o id: " + p.getId());
		em.close();
		
		EntityManager em2 = emf.createEntityManager();
		// p = em2.find(Pet.class, 2l);
		System.out.println("Executando o getConsultas()");
		for (Consulta c : p.getConsultas()) {
			System.out.println(c.getDescricao());
		}
		
		em2.close();
		emf.close();
	}

}
