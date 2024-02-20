package br.com.backEnd.pacotinho.repository;

import br.com.backEnd.pacotinho.model.Animals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalsRepository extends JpaRepository<Animals, Long> {

}
