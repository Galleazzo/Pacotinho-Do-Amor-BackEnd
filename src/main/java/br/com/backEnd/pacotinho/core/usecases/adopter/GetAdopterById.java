package br.com.backEnd.pacotinho.core.usecases.adopter;

import br.com.backEnd.pacotinho.adapters.dtos.AdopterDTO;

public interface GetAdopterById {

    AdopterDTO getAdopterById(Long id);
}
