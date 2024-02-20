package br.com.backEnd.pacotinho.controller;

import br.com.backEnd.pacotinho.model.Animals;
import br.com.backEnd.pacotinho.model.dto.AnimalsDTO;
import br.com.backEnd.pacotinho.service.AnimalsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animals")
public class AnimalsController {

    @Autowired
    private AnimalsService animalsService;


    @GetMapping
    public AnimalsDTO getById(@RequestParam Long id) throws Exception {
        return this.animalsService.getById(id);
    }

    @PostMapping
    public AnimalsDTO save(@RequestBody AnimalsDTO animalsDTO) throws Exception {
        return this.animalsService.save(animalsDTO);
    }


}
