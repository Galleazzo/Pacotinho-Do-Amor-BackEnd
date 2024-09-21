package br.com.backEnd.pacotinho.core.usecases.Animals;

import br.com.backEnd.pacotinho.adapters.dtos.AnimalsDTO;

public interface SaveUseCase {

    AnimalsDTO save(AnimalsDTO animalsDTO);
}
