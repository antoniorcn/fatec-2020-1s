package edu.curso;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
	
	// o prefixo deve ser findBy para que o 
	// Spring implemente a função que procura pela Propriedade informada 
	Set<Pet> findByNome(String nome);
	
	@Query("SELECT p FROM Pet p WHERE p.nome LIKE %:nome%")
	Set<Pet> searchByNome(@Param("nome") String nome);

}
