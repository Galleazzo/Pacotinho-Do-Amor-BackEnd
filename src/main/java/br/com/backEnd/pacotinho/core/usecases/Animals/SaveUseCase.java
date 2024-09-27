package br.com.backEnd.pacotinho.core.usecases.Animals;

import br.com.backEnd.pacotinho.adapters.web.dtos.AnimalsDTO;

public interface SaveUseCase {

    AnimalsDTO save(AnimalsDTO animalsDTO);
}
