package br.com.backEnd.pacotinho.repository;

import br.com.backEnd.pacotinho.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
