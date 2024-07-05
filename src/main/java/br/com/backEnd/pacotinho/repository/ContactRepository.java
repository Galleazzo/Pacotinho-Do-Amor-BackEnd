package br.com.backEnd.pacotinho.repository;

import br.com.backEnd.pacotinho.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
