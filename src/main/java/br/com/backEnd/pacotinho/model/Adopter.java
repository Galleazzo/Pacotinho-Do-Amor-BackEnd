package br.com.backEnd.pacotinho.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "adopter")
public class Adopter {

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
    private Adopter partner;

    @ManyToMany
    private Set<Animals> animals;

    public Adopter(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getResidenceType() {
        return residenceType;
    }

    public void setResidenceType(String residenceType) {
        this.residenceType = residenceType;
    }

    public boolean isAllowsPets() {
        return allowsPets;
    }

    public void setAllowsPets(boolean allowsPets) {
        this.allowsPets = allowsPets;
    }

    public String getPreferredAnimalType() {
        return preferredAnimalType;
    }

    public void setPreferredAnimalType(String preferredAnimalType) {
        this.preferredAnimalType = preferredAnimalType;
    }

    public String getPreferredAnimalAge() {
        return preferredAnimalAge;
    }

    public void setPreferredAnimalAge(String preferredAnimalAge) {
        this.preferredAnimalAge = preferredAnimalAge;
    }

    public String getPreferredAnimalGender() {
        return preferredAnimalGender;
    }

    public void setPreferredAnimalGender(String preferredAnimalGender) {
        this.preferredAnimalGender = preferredAnimalGender;
    }

    public Adopter getPartner() {
        return partner;
    }

    public void setPartner(Adopter partner) {
        this.partner = partner;
    }

    public Set<Animals> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animals> animals) {
        this.animals = animals;
    }
}
