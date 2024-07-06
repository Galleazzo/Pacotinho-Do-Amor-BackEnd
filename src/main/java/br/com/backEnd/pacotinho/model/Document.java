package br.com.backEnd.pacotinho.model;

import javax.persistence.*;

@Entity(name = "document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false, unique = true)
    private String rg;

    public Document(){}

    public Document(String cpf, String rg) {
        this.cpf = cpf;
        this.rg = rg;
    }

    public Long getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                '}';
    }
}
