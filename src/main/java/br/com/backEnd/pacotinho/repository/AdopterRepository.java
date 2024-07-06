package br.com.backEnd.pacotinho.repository;

import br.com.backEnd.pacotinho.model.Adopter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdopterRepository extends JpaRepository<Adopter, Long> {
}