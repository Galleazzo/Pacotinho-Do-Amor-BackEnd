package br.com.backEnd.pacotinho.service;

import br.com.backEnd.pacotinho.model.Animals;
import br.com.backEnd.pacotinho.model.ImageAnimalModel;
import br.com.backEnd.pacotinho.model.dto.AnimalsDTO;
import br.com.backEnd.pacotinho.repository.AnimalsRepository;
import br.com.backEnd.pacotinho.type.AnimalAge;
import br.com.backEnd.pacotinho.type.AnimalSize;
import br.com.backEnd.pacotinho.type.AnimalType;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AnimalsService {

    @Autowired
    private AnimalsRepository animalsRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<AnimalsDTO> getByCriteria(String name, Integer page, Integer pageSize, String sort, String order) {
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sort);
        return this.modelMapper.map(this.animalsRepository.getByCriteria(name, pageable), new TypeToken<Page<Animals>>() {}.getType());
    }

    public AnimalsDTO getById(Long id) throws Exception {
        Animals animal = this.animalsRepository.getById(id);
        AnimalsDTO animalsDTO = new AnimalsDTO();
        animalsDTO.setId(animal.getId());
        animalsDTO.setName(animal.getName());
        animalsDTO.setInstagramURL(animal.getInstagramURL());
        animalsDTO.setAnimalAge(animal.getAnimalAge());
        animalsDTO.setAnimalType(animal.getAnimalType());
        animalsDTO.setRace(animal.getRace());
        animalsDTO.setSize(animal.getSize());
        animalsDTO.setDescription(animal.getDescription());
        animalsDTO.setRegistrationDate(animal.getRegistrationDate());
        animalsDTO.setPriority(animal.getPriority());
        animalsDTO.setAnimalImage(animal.getAnimalImage());
        animalsDTO.setAnimalSex(animal.getAnimalSex());

        return animalsDTO;
    }

    public AnimalsDTO save(AnimalsDTO animalsDTO) {
        Animals animals = new Animals();
        Date registrationDate = new Date();

        if(animalsDTO.getId() != null) {
            animals = this.animalsRepository.getById(animalsDTO.getId());
        }
        if(animalsDTO.getId() == null) {
            animals.setRegistrationDate(registrationDate);
        }

        animals.setName(animalsDTO.getName());
        animals.setInstagramURL(animalsDTO.getInstagramURL());
        animals.setAnimalAge(animalsDTO.getAnimalAge());
        animals.setAnimalType(animalsDTO.getAnimalType());
        animals.setRace(animalsDTO.getRace());
        animals.setSize(animalsDTO.getSize());
        animals.setDescription(animalsDTO.getDescription());
        animals.setPriority(animalsDTO.getPriority());
        animals.setAnimalImage(animalsDTO.getAnimalImage());
        animals.setAnimalSex(animalsDTO.getAnimalSex());

        this.animalsRepository.save(animals);
        return animalsDTO;
    }

    public void deleteAnimal(Long id) throws Exception {
        try{
            this.animalsRepository.deleteById(id);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public List<AnimalsDTO> getAll() {
        List<Animals> animalsList = this.animalsRepository.findAll();
        Type listType = new TypeToken<List<AnimalsDTO>>() {}.getType();
        return this.modelMapper.map(animalsList, listType);
    }

    public Set<ImageAnimalModel> uplodImage(MultipartFile[] multipartFiles) throws IOException {
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

    public void changeActive(Long id) {
        Animals animal = this.animalsRepository.getById(id);
        if (animal.getActive())
            animal.setActive(false);

        if (!animal.getActive())
            animal.setActive(true);

    }
}
