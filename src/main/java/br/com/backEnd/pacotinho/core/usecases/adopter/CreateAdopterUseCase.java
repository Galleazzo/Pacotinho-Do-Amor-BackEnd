package br.com.backEnd.pacotinho.core.usecases.adopter;

import br.com.backEnd.pacotinho.adapters.dtos.AdopterDTO;
import br.com.backEnd.pacotinho.adapters.repositories.AdopterRepository;

public class CreateAdopterUseCase {

    private AdopterRepository adopterRepository;

    public CreateAdopterUseCase(AdopterRepository adopterRepository) {
        this.adopterRepository = adopterRepository;
    }

    public AdopterDTO createAdopter(AdopterDTO adopterDTO){
        return null;
    }
}
