package br.com.backEnd.pacotinho.model;

import br.com.backEnd.pacotinho.type.AnimalAge;
import br.com.backEnd.pacotinho.type.AnimalSize;
import br.com.backEnd.pacotinho.type.AnimalType;

import javax.persistence.*;

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

}
