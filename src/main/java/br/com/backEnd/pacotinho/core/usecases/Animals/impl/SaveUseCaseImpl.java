package br.com.backEnd.pacotinho.core.usecases.Animals.impl;

import br.com.backEnd.pacotinho.adapters.web.dtos.AnimalsDTO;
import br.com.backEnd.pacotinho.adapters.repositories.AnimalsRepository;
import br.com.backEnd.pacotinho.core.domain.entities.Animals;
import br.com.backEnd.pacotinho.core.usecases.Animals.SaveUseCase;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class SaveUseCaseImpl implements SaveUseCase {

    @Autowired
    private AnimalsRepository animalsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AnimalsDTO save(AnimalsDTO animalsDTO) {
        Animals animals = new Animals();
        Date registrationDate = new Date();

        if(animalsDTO.getId() != null) {
            animals = this.animalsRepository.getById(animalsDTO.getId());
        }
        if(animalsDTO.getId() == null) {
            animals.setRegistrationDate(registrationDate);
        }
        this.convertDtoToObject(animalsDTO, animals);

        return this.modelMapper.map(this.animalsRepository.save(animals), AnimalsDTO.class);
    }

    private void convertDtoToObject(AnimalsDTO animalsDTO, Animals animals) {
        animals.setName(animalsDTO.getName());
        animals.setInstagramURL(animalsDTO.getInstagramURL());
        animals.setAnimalAge(animalsDTO.getAnimalAge());
        animals.setAnimalType(animalsDTO.getAnimalType());
        animals.setRace(animalsDTO.getRace());
        animals.setSize(animalsDTO.getSize());
        animals.setDescription(animalsDTO.getDescription());
        animals.setPriority(animalsDTO.getPriority());
        animals.setAnimalImage(animalsDTO.getAnimalImage());
        animals.setAnimalSex(animalsDTO.getAnimalSex());
        animals.setAdoptionDate(null);
        animals.setActive(true);
    }
}
