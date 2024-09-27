package br.com.backEnd.pacotinho.adapters.web.controllers;

import br.com.backEnd.pacotinho.adapters.web.dtos.AdopterDTO;
import org.springframework.http.ResponseEntity;

public interface AdopterController {


    ResponseEntity<AdopterDTO> createAdopter(AdopterDTO adopterDTO);

    ResponseEntity<AdopterDTO> updateAdopter(Long id, AdopterDTO adopterDTO);

    ResponseEntity<Void> deleteAdopter(Long id);

    ResponseEntity<AdopterDTO> getAdopterById(Long id);

    ResponseEntity<AdopterDTO> adoptAnimal(Long adopterId, Long animalId);

}
