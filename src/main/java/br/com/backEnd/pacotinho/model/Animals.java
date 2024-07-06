package br.com.backEnd.pacotinho.model;

import br.com.backEnd.pacotinho.type.AnimalAge;
import br.com.backEnd.pacotinho.type.AnimalSex;
import br.com.backEnd.pacotinho.type.AnimalSize;
import br.com.backEnd.pacotinho.type.AnimalType;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

    @Column(name = "animalSex")
    private AnimalSex animalSex;

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

    @ManyToMany(fetch = FetchType.EAGER, cascade =CascadeType.ALL)
    @JoinTable(name = "animal_image",
            joinColumns = {
                    @JoinColumn(name = "animal_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "image_id")
            })
    private Set<ImageAnimalModel> animalImage;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "adoptionDate")
    private Date adoptionDate;

    @ManyToMany(mappedBy = "animals")
    private Set<Adopter> adopters;

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

    public Set<Adopter> getAdopterPeople() {
        return adopters;
    }

    public void setAdopterPeople(Set<Adopter> adopterPeople) {
        this.adopters = adopterPeople;
    }
}
