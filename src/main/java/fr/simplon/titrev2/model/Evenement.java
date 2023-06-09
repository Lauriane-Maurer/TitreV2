package fr.simplon.titrev2.model;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="evenements")
public class Evenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String type;
    @NotNull
    private String titre;
    @NotNull
    @Column(length = 1000)
    private String description;
    @NotNull
    private LocalDateTime dateDebut;
    @NotNull
    private LocalDateTime dateFin;

    private Integer places_totales;
    private Integer places_restantes;
    private Double tarif;
    private String intervenant;
    private String photo;

    @OneToMany(mappedBy = "evenement", cascade = CascadeType.REMOVE)
    private List<Participant> participants;


    public Evenement() {
    }

    public Evenement(@NotNull String type, @NotNull String titre, @NotNull String description, @NotNull LocalDateTime dateDebut, @NotNull LocalDateTime dateFin, Integer places_totales, Integer places_restantes, Double tarif, String intervenant, String photo) {
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

    public Integer getPlaces_totales() {
        return places_totales;
    }

    public void setPlaces_totales(Integer places_totales) {
        this.places_totales = places_totales;
    }

    public Integer getPlaces_restantes() {
        return places_restantes;
    }

    public void setPlaces_restantes(Integer places_restantes) {
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