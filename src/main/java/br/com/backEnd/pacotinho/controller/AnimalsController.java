package br.com.backEnd.pacotinho.controller;

import br.com.backEnd.pacotinho.exception.AnimalNotFoundException;
import br.com.backEnd.pacotinho.model.Animals;
import br.com.backEnd.pacotinho.model.ImageAnimalModel;
import br.com.backEnd.pacotinho.model.dto.AnimalsDTO;
import br.com.backEnd.pacotinho.service.AnimalsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@RestController(value = "APIs to get, post, put and delete animals")
@RequestMapping("/animals")
public class AnimalsController {

    @Autowired
    private AnimalsService animalsService;

    @GetMapping
    public ResponseEntity<AnimalsDTO> getById(@RequestParam Long id) {
        try {
            AnimalsDTO animalDTO = animalsService.getById(id);
            return new ResponseEntity<>(animalDTO, HttpStatus.OK);
        } catch (AnimalNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<AnimalsDTO> save(@RequestPart("animal") AnimalsDTO animalsDTO, @RequestPart(value = "imageFile", required = false) MultipartFile[] file) throws Exception {
        Set<ImageAnimalModel> images = new HashSet<>();

        if (file != null && file.length > 0) {
            images = this.animalsService.uplodImage(file);
        }

        animalsDTO.setAnimalImage(images);
        return new ResponseEntity<>(this.animalsService.save(animalsDTO), HttpStatus.CREATED);
    }

    @GetMapping(path = "/getByCriteria")
    public ResponseEntity<Page<AnimalsDTO>> getByCriteria(@RequestParam String name, @RequestParam Integer page, @RequestParam Integer pageSize, @RequestParam String sort, @RequestParam String order){
        return new ResponseEntity<>(this.animalsService.getByCriteria(name, page, pageSize, sort, order), HttpStatus.OK);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@RequestParam Long id) throws Exception {
        animalsService.deleteAnimal(id);
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<AnimalsDTO>> getAllAnimals(){
        return new ResponseEntity<>(this.animalsService.getAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/changeActive")
    public void changeActive(@RequestParam Long id, @RequestParam() Date adoptionDate) {
        this.animalsService.changeActive(id, adoptionDate);
    }

}
