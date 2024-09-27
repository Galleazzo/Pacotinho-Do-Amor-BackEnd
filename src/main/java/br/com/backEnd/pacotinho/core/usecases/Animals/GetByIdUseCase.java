package br.com.backEnd.pacotinho.core.usecases.Animals;

import br.com.backEnd.pacotinho.adapters.web.dtos.AnimalsDTO;

public interface GetByIdUseCase {

    AnimalsDTO getById(Long id) throws Exception;
}
