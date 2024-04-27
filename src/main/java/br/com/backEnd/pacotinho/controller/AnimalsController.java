package br.com.backEnd.pacotinho.controller;

import br.com.backEnd.pacotinho.model.Animals;
import br.com.backEnd.pacotinho.model.ImageAnimalModel;
import br.com.backEnd.pacotinho.model.dto.AnimalsDTO;
import br.com.backEnd.pacotinho.service.AnimalsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/animals")
public class AnimalsController {

    @Autowired
    private AnimalsService animalsService;

    @GetMapping
    public AnimalsDTO getById(@RequestParam Long id) throws Exception {
        return this.animalsService.getById(id);
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public AnimalsDTO save(@RequestPart("animal") AnimalsDTO animalsDTO, @RequestPart("imageFile") MultipartFile[] file) throws Exception {
        Set<ImageAnimalModel> images = uplodImage(file);
        animalsDTO.setAnimalImage(images);
        return this.animalsService.save(animalsDTO);
    }

    @GetMapping(path = "/getByCriteria")
    public Page<AnimalsDTO> getByCriteria(@RequestParam String name, @RequestParam Integer page, @RequestParam Integer pageSize, @RequestParam String sort, @RequestParam String order){
        return this.animalsService.getByCriteria(name, page, pageSize, sort, order);
    }

    @DeleteMapping
    public void deleteById(@RequestParam Long id) throws Exception {
        this.animalsService.deleteAnimal(id);
    }

    @GetMapping(path = "/getAll")
    public List<AnimalsDTO> getAllAnimals(){
        return this.animalsService.getAll();
    }

    private Set<ImageAnimalModel> uplodImage(MultipartFile[] multipartFiles) throws IOException {
        Set<ImageAnimalModel> imageModels = new HashSet<>();

        for(MultipartFile file: multipartFiles) {
            ImageAnimalModel imageModel = new ImageAnimalModel(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes());
            imageModels.add(imageModel);
        }
        return imageModels;
    }

}
