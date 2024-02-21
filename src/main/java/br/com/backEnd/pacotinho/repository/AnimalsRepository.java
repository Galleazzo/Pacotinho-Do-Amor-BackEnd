package br.com.backEnd.pacotinho.repository;

import br.com.backEnd.pacotinho.model.Animals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalsRepository extends JpaRepository<Animals, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM animals WHERE id = :id")
    Animals getById(@Param("id") Long id);

}
