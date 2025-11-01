package com.gestionmedecin.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "specialites")
public class Specialite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nom;

    @Column(length = 500)
    private String description;

    @OneToMany(mappedBy = "specialite", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Medecin> medecins;
}
