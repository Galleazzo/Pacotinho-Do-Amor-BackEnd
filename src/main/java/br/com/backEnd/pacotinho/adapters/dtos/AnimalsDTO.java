package br.com.backEnd.pacotinho.adapters.dtos;

import br.com.backEnd.pacotinho.core.domain.entities.ImageAnimalModel;
import br.com.backEnd.pacotinho.core.domain.type.AnimalAge;
import br.com.backEnd.pacotinho.core.domain.type.AnimalSex;
import br.com.backEnd.pacotinho.core.domain.type.AnimalSize;
import br.com.backEnd.pacotinho.core.domain.type.AnimalType;

import java.util.Date;
import java.util.Set;

public class AnimalsDTO {

    private Long id;
    private String name;
    private String instagramURL;
    private AnimalAge animalAge;
    private AnimalType animalType;
    private AnimalSex animalSex;
    private String race;
    private AnimalSize size;
    private String description;
    private Date registrationDate;
    private Long priority;
    private Set<ImageAnimalModel> animalImage;
    private Boolean active;
    private Date adoptionDate;

    public AnimalsDTO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstagramURL() {
        return instagramURL;
    }

    public void setInstagramURL(String instagramURL) {
        this.instagramURL = instagramURL;
    }

    public AnimalAge getAnimalAge() {
        return animalAge;
    }

    public void setAnimalAge(AnimalAge animalAge) {
        this.animalAge = animalAge;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public AnimalSize getSize() {
        return size;
    }

    public void setSize(AnimalSize size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public Set<ImageAnimalModel> getAnimalImage() {
        return animalImage;
    }

    public void setAnimalImage(Set<ImageAnimalModel> animalImage) {
        this.animalImage = animalImage;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public AnimalSex getAnimalSex() {
        return animalSex;
    }

    public void setAnimalSex(AnimalSex animalSex) {
        this.animalSex = animalSex;
    }

    public Date getAdoptionDate() {
        return adoptionDate;
    }

    public void setAdoptionDate(Date adoptionDate) {
        this.adoptionDate = adoptionDate;
    }
}
