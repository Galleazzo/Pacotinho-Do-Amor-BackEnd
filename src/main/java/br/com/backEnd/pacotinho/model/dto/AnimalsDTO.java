package br.com.backEnd.pacotinho.model.dto;

import java.util.Date;

public class AnimalsDTO {

    private Long id;
    private String name;
    private String instagramURL;
    private Long animalAge;
    private Long animalType;
    private String race;
    private Long size;
    private String description;
    private Date registrationDate;

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

    public Long getAnimalAge() {
        return animalAge;
    }

    public void setAnimalAge(Long animalAge) {
        this.animalAge = animalAge;
    }

    public Long getAnimalType() {
        return animalType;
    }

    public void setAnimalType(Long animalType) {
        this.animalType = animalType;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
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
}
