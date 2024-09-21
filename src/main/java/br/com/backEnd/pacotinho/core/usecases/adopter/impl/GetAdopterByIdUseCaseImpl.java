package br.com.backEnd.pacotinho.core.usecases.adopter.impl;

import br.com.backEnd.pacotinho.adapters.dtos.AdopterDTO;
import br.com.backEnd.pacotinho.adapters.repositories.AdopterRepository;
import br.com.backEnd.pacotinho.adapters.repositories.AnimalsRepository;
import br.com.backEnd.pacotinho.core.domain.entities.Adopter;
import br.com.backEnd.pacotinho.core.usecases.adopter.GetAdopterById;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class GetAdopterByIdUseCaseImpl implements GetAdopterById {

    @Autowired
    private AdopterRepository adopterRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AdopterDTO getAdopterById(Long id) {
        Adopter adopter = adopterRepository.findById(id).orElseThrow(() -> new RuntimeException("Adopter not found with id " + id));
        return modelMapper.map(adopter, AdopterDTO.class);
    }
}
