package br.com.backEnd.pacotinho.repository;

import br.com.backEnd.pacotinho.model.AdopterPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdopterPersonRepository extends JpaRepository<AdopterPerson, Long> {
}