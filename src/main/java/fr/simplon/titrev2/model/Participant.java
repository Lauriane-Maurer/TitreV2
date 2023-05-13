package fr.simplon.titrev2.model;

import jakarta.persistence.*;

@Entity
@Table(name="participants")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String prenom;
    private String nom;
    private String telephone;
    private String email;
    private int code_postal;
    private String username;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_evenement", referencedColumnName = "id", nullable = false)
    private Evenement evenement;

    public Participant() {
    }

    public Participant(String prenom, String nom, String telephone, String email, int code_postal, String username, Evenement evenement) {
        this.prenom = prenom;
        this.nom = nom;
        this.telephone = telephone;
        this.email = email;
        this.code_postal = code_postal;
        this.username = username;
        this.evenement = evenement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(int code_postal) {
        this.code_postal = code_postal;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }
}