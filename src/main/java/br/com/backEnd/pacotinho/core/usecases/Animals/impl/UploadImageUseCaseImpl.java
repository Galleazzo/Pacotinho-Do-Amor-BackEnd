package br.com.backEnd.pacotinho.core.usecases.Animals.impl;

import br.com.backEnd.pacotinho.core.domain.entities.ImageAnimalModel;
import br.com.backEnd.pacotinho.core.usecases.Animals.UploadImageUseCase;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class UploadImageUseCaseImpl implements UploadImageUseCase {

    @Override
    public Set<ImageAnimalModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
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
