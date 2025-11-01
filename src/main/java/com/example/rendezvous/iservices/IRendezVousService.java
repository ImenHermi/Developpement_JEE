package com.example.rendezvous.iservices;

import com.example.rendezvous.entities.RendezVous;
import java.util.List;

public interface IRendezVousService { // Interface pour les services liés à l'entité RendezVous

    RendezVous createRendezVous(RendezVous rendezVous); // Méthode pour créer un nouveau rendez-vous

    List<RendezVous> getAllRendezVous(); // Méthode pour récupérer tous les rendez-vous

    RendezVous updateRendezVousById(RendezVous rendezVous, Long id); // Méthode pour mettre à jour un rendez-vous par son ID

    void deleteRendezVousById(Long id); // Méthode pour supprimer un rendez-vous par son ID
}
