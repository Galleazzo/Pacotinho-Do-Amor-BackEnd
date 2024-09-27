package br.com.backEnd.pacotinho.adapters.web.controllers.impl;

import br.com.backEnd.pacotinho.adapters.web.controllers.AdopterController;
import br.com.backEnd.pacotinho.adapters.web.dtos.AdopterDTO;
import br.com.backEnd.pacotinho.core.usecases.adopter.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adopters")
public class AdopterControllerImpl implements AdopterController {

    @Autowired
    private AdoptAnimalUseCase adoptAnimalUseCase;

    @Autowired
    private CreateAdopterUseCase createAdopter;

    @Autowired
    private DeleteAdopterUseCase deleteAdopter;

    @Autowired
    private GetAdopterById getAdopterById;

    @Autowired
    private UpdateAdopterUseCase updateAdopter;

    @Override
    @PostMapping
    public ResponseEntity<AdopterDTO> createAdopter(@RequestBody AdopterDTO adopterDTO) {
        return ResponseEntity.ok(this.createAdopter.createAdopter(adopterDTO));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<AdopterDTO> updateAdopter(@PathVariable Long id, @RequestBody AdopterDTO adopterDTO) {
        return ResponseEntity.ok(this.updateAdopter.updateAdopter(id, adopterDTO));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdopter(@PathVariable Long id) {
        this.deleteAdopter.deleteAdopter(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<AdopterDTO> getAdopterById(@PathVariable Long id) {
        return ResponseEntity.ok(this.getAdopterById.getAdopterById(id));
    }

    @Override
    @PostMapping("/{adopterId}/adopt/{animalId}")
    public ResponseEntity<AdopterDTO> adoptAnimal(@PathVariable Long adopterId, @PathVariable Long animalId) {
        return ResponseEntity.ok(this.adoptAnimalUseCase.adoptAnimal(adopterId, animalId));
    }
}
