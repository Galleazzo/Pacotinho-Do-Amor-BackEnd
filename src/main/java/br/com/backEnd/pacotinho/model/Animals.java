package br.com.backEnd.pacotinho.model;

import br.com.backEnd.pacotinho.type.AnimalAge;
import br.com.backEnd.pacotinho.type.AnimalSize;
import br.com.backEnd.pacotinho.type.AnimalType;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "animals")
public class Animals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "instagramURL")
    private String instagramURL;

    @Column(name = "animalAge")
    private AnimalAge animalAge;

    @Column(name = "animalType")
    private AnimalType animalType;

    @Column(name = "race")
    private String race;

    @Column(name = "size")
    private AnimalSize size;

    @Column(name = "description")
    private String description;

    @Column(name = "registrationDate")
    private Date registrationDate;

    @Column(name = "priority")
    private Long priority;

    @Lob
    @Column(name = "animalImage", columnDefinition="BLOB")
    private byte[] animalImage;

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

    public byte[] getAnimalImage() {
        return animalImage;
    }

    public void setAnimalImage(byte[] animalImage) {
        this.animalImage = animalImage;
    }
}
