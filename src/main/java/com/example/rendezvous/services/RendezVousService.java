package com.example.rendezvous.services;

import com.example.rendezvous.entities.RendezVous;
import com.example.rendezvous.Repositories.RendezVousRepository;
import com.example.rendezvous.iservices.IRendezVousService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Indiquer que c'est un service Spring
public class RendezVousService implements IRendezVousService {

    private final RendezVousRepository rendezVousRepository; // Déclaration du repository

    // Injection via constructeur (bonne pratique recommandée)
    public RendezVousService(RendezVousRepository rendezVousRepository) {
        this.rendezVousRepository = rendezVousRepository;
    }

    // ===============================
    // 🔹 Implémentation des méthodes
    // ===============================

    @Override
    public RendezVous createRendezVous(RendezVous rendezVous) { // Créer un rendez-vous
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public List<RendezVous> getAllRendezVous() { // Afficher tous les rendez-vous
        return rendezVousRepository.findAll();
    }

    @Override
    public RendezVous updateRendezVousById(RendezVous newRendezVous, Long id) { // Modifier un RDV par ID
        Optional<RendezVous> existingRendezVous = rendezVousRepository.findById(id);

        if (existingRendezVous.isPresent()) {
            RendezVous rdv = existingRendezVous.get();

            rdv.setDate(newRendezVous.getDate());
            rdv.setStatut(newRendezVous.getStatut());
            rdv.setPatient(newRendezVous.getPatient());
            rdv.setMedecin(newRendezVous.getMedecin());

            return rendezVousRepository.save(rdv); // Sauvegarde après modification
        } else {
            return null; // Ou tu peux lancer une exception personnalisée
        }
    }

    @Override
    public void deleteRendezVousById(Long id) { // Supprimer un rendez-vous
        rendezVousRepository.deleteById(id);
    }
}

