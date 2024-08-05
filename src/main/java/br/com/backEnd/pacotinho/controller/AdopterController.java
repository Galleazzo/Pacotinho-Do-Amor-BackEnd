package br.com.backEnd.pacotinho.controller;

import br.com.backEnd.pacotinho.model.dto.AdopterDTO;
import br.com.backEnd.pacotinho.service.AdopterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adopters")
public class AdopterController {

    @Autowired
    private AdopterService adopterService;

    @PostMapping
    public ResponseEntity<AdopterDTO> createAdopter(@RequestBody AdopterDTO adopterDTO) {
        return ResponseEntity.ok(adopterService.createAdopter(adopterDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdopterDTO> updateAdopter(@PathVariable Long id, @RequestBody AdopterDTO adopterDTO) {
        return ResponseEntity.ok(adopterService.updateAdopter(id, adopterDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdopter(@PathVariable Long id) {
        adopterService.deleteAdopter(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdopterDTO> getAdopterById(@PathVariable Long id) {
        return ResponseEntity.ok(adopterService.getAdopterById(id));
    }

    @PostMapping("/{adopterId}/adopt/{animalId}")
    public ResponseEntity<AdopterDTO> adoptAnimal(@PathVariable Long adopterId, @PathVariable Long animalId) {
        return ResponseEntity.ok(adopterService.adoptAnimal(adopterId, animalId));
    }
}
