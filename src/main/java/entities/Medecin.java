package com.gestionmedecin.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Entity @Data
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String email;

    @ManyToOne
    @JoinColumn(name = "specialite_id")
    private Specialite specialite;

    @OneToMany(mappedBy = "medecin", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RendezVous> rendezVousList = new ArrayList<>();
}
