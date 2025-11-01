package com.example.rendezvous.entities;

import jakarta.persistence.*; // Importer les annotations JPA
import lombok.*; // Importer les annotations Lombok
import java.time.LocalDateTime; // Importer la classe LocalDateTime pour la date

@Entity // Spécifier que c’est une entité JPA
@Table(name = "rendez_vous") // Spécifier le nom de la table dans la base de données
@Getter // Générer les getters pour tous les champs
@Setter // Générer les setters pour tous les champs
@NoArgsConstructor // Générer un constructeur sans arguments
@AllArgsConstructor // Générer un constructeur avec tous les arguments
@ToString // Générer une méthode toString
public class RendezVous { // Définir la classe RendezVous comme une entité JPA

    @Id // Spécifier que c’est la clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Spécifier la stratégie de génération de la clé primaire
    private Long id;

    private LocalDateTime date; // Date et heure du rendez-vous
    private String statut; // Statut du rendez-vous (prévu, annulé, terminé...)

    // ============================
    // 🔹 Relations
    // ============================

    @ManyToOne // Relation N rendez-vous pour 1 patient
    @JoinColumn(name = "patient_id") // Clé étrangère vers la table Patient
    private Patient patient;

    @ManyToOne // Relation N rendez-vous pour 1 médecin
    @JoinColumn(name = "medecin_id") // Clé étrangère vers la table Medecin
    private Medecin medecin;
}

