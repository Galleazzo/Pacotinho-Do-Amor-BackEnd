package br.com.backEnd.pacotinho.model.dto;

import java.util.Set;

public class AdopterDTO {
    private Long id;
    private String fullName;
    private String dateOfBirth;
    private DocumentDTO document;
    private AddressDTO address;
    private ContactDTO contact;
    private String residenceType;
    private boolean allowsPets;
    private String preferredAnimalType;
    private String preferredAnimalAge;
    private String preferredAnimalGender;
    private AdopterDTO partner;
    private Set<AnimalsDTO> animals;

    // Getters and Setters
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

    public DocumentDTO getDocument() {
        return document;
    }

    public void setDocument(DocumentDTO document) {
        this.document = document;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public ContactDTO getContact() {
        return contact;
    }

    public void setContact(ContactDTO contact) {
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

    public AdopterDTO getPartner() {
        return partner;
    }

    public void setPartner(AdopterDTO partner) {
        this.partner = partner;
    }

    public Set<AnimalsDTO> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<AnimalsDTO> animals) {
        this.animals = animals;
    }
}

