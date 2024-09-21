package br.com.backEnd.pacotinho.adapters.controllers;

import br.com.backEnd.pacotinho.adapters.dtos.AnimalsDTO;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public interface AnimalsController {

    ResponseEntity<AnimalsDTO> getById(Long id);

    ResponseEntity<AnimalsDTO> save(AnimalsDTO animalsDTO, MultipartFile[] file) throws Exception;

    ResponseEntity<Page<AnimalsDTO>> getByCriteria(String name, Integer page, Integer pageSize, String sort, String order);

    void deleteById(Long id) throws Exception;

    ResponseEntity<List<AnimalsDTO>> getAllAnimals();

    void changeActive(Long id, Date adoptionDate);
}
