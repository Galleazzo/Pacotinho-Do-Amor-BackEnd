package br.com.backEnd.pacotinho.core.usecases.adopter.impl;

import br.com.backEnd.pacotinho.adapters.dtos.AdopterDTO;
import br.com.backEnd.pacotinho.adapters.repositories.AdopterRepository;
import br.com.backEnd.pacotinho.adapters.repositories.AnimalsRepository;
import br.com.backEnd.pacotinho.core.domain.entities.Adopter;
import br.com.backEnd.pacotinho.core.usecases.adopter.UpdateAdopterUseCase;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class UpdateAdopterUseCaseImpl implements UpdateAdopterUseCase {

    @Autowired
    private AdopterRepository adopterRepository;

    @Autowired
    private AnimalsRepository animalsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
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
}
