package edu.curso;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/petServlet")
public class PetServlet extends HttpServlet {	
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException { 
		List<Pet> lista = (List<Pet>)getServletContext().getAttribute("LISTA");
		EntityManagerFactory emf = (EntityManagerFactory)getServletContext().getAttribute("EMF");
		if (emf == null) { 
			emf = Persistence.createEntityManagerFactory("PET");
			getServletContext().setAttribute("EMF", emf);
		}
		
		if (lista == null) { 
			System.out.println("### Criando a lista ###");
			lista = new ArrayList<>();
			getServletContext().setAttribute("LISTA", lista);			
		}
		
		String nome = req.getParameter("nome");
		String raca = req.getParameter("raca");
		String nascimento = req.getParameter("nascimento");
		String cmd = req.getParameter("cmd");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String msg = null;
		EntityManager em = emf.createEntityManager();
		if ("adicionar".equals(cmd)) {
			Pet p = new Pet();
			p.setNome(nome);
			p.setRaca(raca);
			p.setNascimento(LocalDate.parse(nascimento, formatter));
			
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
		
			msg = String.format("O Pet %s foi cadastrado com sucesso", nome);
		} else if ("pesquisar".equals(cmd)) { 
			String sql = "select p from Pet p where p.nome like :pet_nome";
			TypedQuery<Pet> qry = em.createQuery(sql, Pet.class);
			qry.setParameter("pet_nome", "%" + nome + "%");
			lista.clear();
			lista.addAll(qry.getResultList());
			msg = String.format("Foram encontrados %d pets", lista.size());
		}
		
		em.close();
		HttpSession session = req.getSession();
		session.setAttribute("MENSAGEM", msg);
		
		res.sendRedirect("./pet.jsp");
	}

}
