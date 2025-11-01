package com.gestionmedecin.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity @Data
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateHeure;
    private String patientNom;
    private String motif;

    @ManyToOne
    @JoinColumn(name = "medecin_id")
    private Medecin medecin;
}
