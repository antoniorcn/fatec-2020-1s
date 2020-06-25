package edu.curso;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long>{

	Set<Pet> findByNome(String nome);
	
	@Query("select p from Pet p where p.nome like %:nome%")
	Set<Pet> searchByNome(@Param("nome") String nome);
}
