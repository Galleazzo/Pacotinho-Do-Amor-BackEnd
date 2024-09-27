package br.com.backEnd.pacotinho.core.usecases.adopter.impl;

import br.com.backEnd.pacotinho.adapters.web.dtos.AdopterDTO;
import br.com.backEnd.pacotinho.adapters.repositories.AdopterRepository;
import br.com.backEnd.pacotinho.core.domain.entities.Adopter;
import br.com.backEnd.pacotinho.core.usecases.adopter.CreateAdopterUseCase;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class CreateAdopterUseCaseImpl implements CreateAdopterUseCase {

    @Autowired
    private AdopterRepository adopterRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public AdopterDTO createAdopter(AdopterDTO adopterDTO) {
        Adopter adopter = modelMapper.map(adopterDTO, Adopter.class);
        Adopter savedAdopter = adopterRepository.save(adopter);
        return modelMapper.map(savedAdopter, AdopterDTO.class);
    }
}
