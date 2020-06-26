package edu.curso;

import java.util.List;

public interface PetDAO {
	void adicionar(Pet p);
	List<Pet> pesquisarPorNome(String nome);
}
