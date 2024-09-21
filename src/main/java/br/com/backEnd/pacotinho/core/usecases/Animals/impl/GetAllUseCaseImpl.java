package br.com.backEnd.pacotinho.core.usecases.Animals.impl;

import br.com.backEnd.pacotinho.adapters.dtos.AnimalsDTO;
import br.com.backEnd.pacotinho.adapters.repositories.AnimalsRepository;
import br.com.backEnd.pacotinho.core.domain.entities.Animals;
import br.com.backEnd.pacotinho.core.usecases.Animals.GetAllUseCase;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Type;
import java.util.List;

public class GetAllUseCaseImpl implements GetAllUseCase {

    @Autowired
    private AnimalsRepository animalsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<AnimalsDTO> getAll() {
        List<Animals> animalsList = this.animalsRepository.findAll();
        Type listType = new TypeToken<List<AnimalsDTO>>() {}.getType();
        return this.modelMapper.map(animalsList, listType);
    }
}
