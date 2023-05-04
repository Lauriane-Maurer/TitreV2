package fr.simplon.titrev2.model;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name="evenements")
public class Evenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String titre;
    @NotNull
    @Column(length = 1000)
    private String description;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;

    private int places_totales;
    private int places_restantes;
    private Double tarif;
    private String intervenant;
    private String photo;

    public Evenement() {
    }

    public Evenement(String type, String titre, @NotNull String description, LocalDateTime dateDebut, LocalDateTime dateFin, int places_totales, int places_restantes, Double tarif, String intervenant, String photo) {
        this.type = type;
        this.titre = titre;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.places_totales = places_totales;
        this.places_restantes = places_restantes;
        this.tarif = tarif;
        this.intervenant = intervenant;
        this.photo = photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public int getPlaces_totales() {
        return places_totales;
    }

    public void setPlaces_totales(int places_totales) {
        this.places_totales = places_totales;
    }

    public int getPlaces_restantes() {
        return places_restantes;
    }

    public void setPlaces_restantes(int places_restantes) {
        this.places_restantes = places_restantes;
    }

    public Double getTarif() {
        return tarif;
    }

    public void setTarif(Double tarif) {
        this.tarif = tarif;
    }

    public String getIntervenant() {
        return intervenant;
    }

    public void setIntervenant(String intervenant) {
        this.intervenant = intervenant;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}