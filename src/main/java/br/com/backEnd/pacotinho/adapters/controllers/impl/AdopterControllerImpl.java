package br.com.backEnd.pacotinho.adapters.controllers.impl;

import br.com.backEnd.pacotinho.adapters.controllers.AdopterController;
import br.com.backEnd.pacotinho.adapters.dtos.AdopterDTO;
import br.com.backEnd.pacotinho.core.usecases.adopter.AdoptAnimalUseCase;
import br.com.backEnd.pacotinho.service.AdopterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adopters")
public class AdopterControllerImpl implements AdopterController {

    @Autowired
    private AdopterService adopterService;

    @Autowired
    private AdoptAnimalUseCase adoptAnimalUseCase;

    @Override
    @PostMapping
    public ResponseEntity<AdopterDTO> createAdopter(@RequestBody AdopterDTO adopterDTO) {
        return ResponseEntity.ok(adopterService.createAdopter(adopterDTO));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<AdopterDTO> updateAdopter(@PathVariable Long id, @RequestBody AdopterDTO adopterDTO) {
        return ResponseEntity.ok(adopterService.updateAdopter(id, adopterDTO));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdopter(@PathVariable Long id) {
        adopterService.deleteAdopter(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<AdopterDTO> getAdopterById(@PathVariable Long id) {
        return ResponseEntity.ok(adopterService.getAdopterById(id));
    }

    @Override
    @PostMapping("/{adopterId}/adopt/{animalId}")
    public ResponseEntity<AdopterDTO> adoptAnimal(@PathVariable Long adopterId, @PathVariable Long animalId) {
        return ResponseEntity.ok(this.adoptAnimalUseCase.adoptAnimal(adopterId, animalId));
    }
}
