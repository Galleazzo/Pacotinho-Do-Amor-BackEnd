package br.com.backEnd.pacotinho.core.usecases.adopter;

import br.com.backEnd.pacotinho.adapters.dtos.AdopterDTO;

public interface CreateAdopterUseCase {

    AdopterDTO createAdopter(AdopterDTO adopterDTO);
}
