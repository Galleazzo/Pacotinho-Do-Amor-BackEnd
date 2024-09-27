package br.com.backEnd.pacotinho.core.usecases.Animals;

import br.com.backEnd.pacotinho.adapters.web.dtos.AnimalsDTO;

import java.util.List;

public interface GetAllUseCase {

    List<AnimalsDTO> getAll();
}
