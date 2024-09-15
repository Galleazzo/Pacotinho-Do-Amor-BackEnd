package br.com.backEnd.pacotinho.service;

import br.com.backEnd.pacotinho.core.domain.entities.Adopter;
import br.com.backEnd.pacotinho.core.domain.entities.Animals;
import br.com.backEnd.pacotinho.adapters.dtos.AdopterDTO;
import br.com.backEnd.pacotinho.adapters.repositories.AdopterRepository;
import br.com.backEnd.pacotinho.adapters.repositories.AnimalsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AdopterService {

    @Autowired
    private AdopterRepository adopterRepository;

    @Autowired
    private AnimalsRepository animalsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public AdopterDTO createAdopter(AdopterDTO adopterDTO) {
        Adopter adopter = modelMapper.map(adopterDTO, Adopter.class);
        Adopter savedAdopter = adopterRepository.save(adopter);
        return modelMapper.map(savedAdopter, AdopterDTO.class);
    }

    @Transactional
    public AdopterDTO updateAdopter(Long id, AdopterDTO updatedAdopterDTO) {
        Optional<Adopter> optionalAdopter = adopterRepository.findById(id);
        if (optionalAdopter.isPresent()) {
            Adopter existingAdopter = optionalAdopter.get();
            modelMapper.map(updatedAdopterDTO, existingAdopter);
            existingAdopter.setId(id);
            Adopter savedAdopter = adopterRepository.save(existingAdopter);
            return modelMapper.map(savedAdopter, AdopterDTO.class);
        } else {
            throw new RuntimeException("Adopter not found with id " + id);
        }
    }

    @Transactional
    public void deleteAdopter(Long id) {
        adopterRepository.deleteById(id);
    }

    public AdopterDTO getAdopterById(Long id) {
        Adopter adopter = adopterRepository.findById(id).orElseThrow(() -> new RuntimeException("Adopter not found with id " + id));
        return modelMapper.map(adopter, AdopterDTO.class);
    }

    @Transactional
    public AdopterDTO adoptAnimal(Long adopterId, Long animalId) {
        Adopter adopter = adopterRepository.findById(adopterId).orElseThrow(() -> new RuntimeException("Adopter not found with id " + adopterId));
        Animals animal = animalsRepository.findById(animalId).orElseThrow(() -> new RuntimeException("Animal not found with id " + animalId));

        adopter.getAnimals().add(animal);

        if (animal.getAdopterPeople().size() < 2) {
            animal.getAdopterPeople().add(adopter);
        } else {
            throw new RuntimeException("Animal already has maximum number of adopters");
        }

        animalsRepository.save(animal);
        Adopter savedAdopter = adopterRepository.save(adopter);

        return modelMapper.map(savedAdopter, AdopterDTO.class);
    }
}
