package br.com.backEnd.pacotinho.repository;

import br.com.backEnd.pacotinho.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
}
