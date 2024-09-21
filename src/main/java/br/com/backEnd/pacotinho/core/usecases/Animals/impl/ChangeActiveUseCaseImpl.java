package br.com.backEnd.pacotinho.core.usecases.Animals.impl;

import br.com.backEnd.pacotinho.adapters.repositories.AnimalsRepository;
import br.com.backEnd.pacotinho.core.domain.entities.Animals;
import br.com.backEnd.pacotinho.core.usecases.Animals.ChangeActiveUseCase;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class ChangeActiveUseCaseImpl implements ChangeActiveUseCase {

    @Autowired
    private AnimalsRepository animalsRepository;

    @Override
    public void changeActive(Long id, Date adoptionDate) {
        Animals animal = this.animalsRepository.getById(id);
        animal.setActive(!animal.getActive());

        if (animal.getActive() == false) {
            LocalDateTime now = LocalDateTime.now();
            Date date = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
            animal.setAdoptionDate(date);

            animal.setAdoptionDate(adoptionDate);
        } else {
            animal.setAdoptionDate(null);
        }
        this.animalsRepository.save(animal);
    }
}
