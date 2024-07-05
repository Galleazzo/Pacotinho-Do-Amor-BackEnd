package br.com.backEnd.pacotinho.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "adopterPerson")
public class AdopterPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "document_id", referencedColumnName = "id")
    private Document document;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Contact contact;

    @Column(nullable = false)
    private String residenceType;

    @Column(nullable = false)
    private boolean allowsPets;

    @Column(nullable = false)
    private String preferredAnimalType;

    @Column(nullable = false)
    private String preferredAnimalAge;

    @Column(nullable = false)
    private String preferredAnimalGender;

    @ManyToOne
    @JoinColumn(name = "partner_id")
    private AdopterPerson partner;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "adopter_animals",
            joinColumns = @JoinColumn(name = "adopter_id"),
            inverseJoinColumns = @JoinColumn(name = "animal_id"))
    private Set<Animals> animals;


}
