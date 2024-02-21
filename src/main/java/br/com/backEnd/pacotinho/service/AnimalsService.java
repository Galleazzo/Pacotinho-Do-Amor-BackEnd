package br.com.backEnd.pacotinho.service;

import br.com.backEnd.pacotinho.model.Animals;
import br.com.backEnd.pacotinho.model.dto.AnimalsDTO;
import br.com.backEnd.pacotinho.repository.AnimalsRepository;
import br.com.backEnd.pacotinho.type.AnimalAge;
import br.com.backEnd.pacotinho.type.AnimalSize;
import br.com.backEnd.pacotinho.type.AnimalType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AnimalsService {

    @Autowired
    private AnimalsRepository animalsRepository;

    @Autowired
    private ModelMapper modelMapper;

    public AnimalsDTO getById(Long id) throws Exception {
        Animals animal = this.animalsRepository.getById(id);
        return this.modelMapper.map(animal, AnimalsDTO.class);
    }

    public AnimalsDTO save(AnimalsDTO animalsDTO) {
        Animals animals = new Animals();
        Date registrationDate = new Date();

        if(animalsDTO.getId() != null) {
            animals.setId(animals.getId());
        }
        if(animalsDTO.getRegistrationDate() == null) {
            animals.setRegistrationDate(registrationDate);
        }

        animals.setName(animalsDTO.getName());
        animals.setInstagramURL(animalsDTO.getInstagramURL());
        animals.setAnimalAge(AnimalAge.getByValue(animalsDTO.getAnimalAge()));
        animals.setAnimalType(AnimalType.getByValue(animalsDTO.getAnimalType()));
        animals.setRace(animalsDTO.getRace());
        animals.setSize(AnimalSize.getByValue(animalsDTO.getSize()));
        animals.setDescription(animalsDTO.getDescription());

        this.animalsRepository.save(animals);
        return animalsDTO;
    }
}
