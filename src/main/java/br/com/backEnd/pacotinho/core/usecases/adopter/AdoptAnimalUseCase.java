package br.com.backEnd.pacotinho.core.usecases.adopter;

import br.com.backEnd.pacotinho.adapters.dtos.AdopterDTO;

public interface AdoptAnimalUseCase {

    public AdopterDTO adoptAnimal(Long adopterId, Long animalId);
}
