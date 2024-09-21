package br.com.backEnd.pacotinho.core.usecases.Animals;

import br.com.backEnd.pacotinho.core.domain.entities.ImageAnimalModel;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Set;

public interface UploadImageUseCase {

    Set<ImageAnimalModel> uploadImage(MultipartFile[] multipartFiles) throws IOException;
}
