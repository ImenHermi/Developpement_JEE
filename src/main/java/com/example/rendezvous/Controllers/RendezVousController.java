package com.example.rendezvous.Controllers;

import com.example.rendezvous.entities.RendezVous;
import com.example.rendezvous.services.RendezVousService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indique que c'est un contrôleur REST
@RequestMapping("/api/rendezvous") // URL de base pour toutes les méthodes
public class RendezVousController {

    // Injection du service pour utiliser la logique métier
    private final RendezVousService rendezVousService;

    public RendezVousController(RendezVousService rendezVousService) {
        this.rendezVousService = rendezVousService;
    }

    // ============================================
    // 🔹 1. Ajouter un nouveau rendez-vous (CREATE)
    // ============================================
    @PostMapping("/add")
    public RendezVous createRendezVous(@RequestBody RendezVous rendezVous) {
        return rendezVousService.createRendezVous(rendezVous); // Appel du service pour sauvegarder
    }

    // ============================================
    // 🔹 2. Afficher tous les rendez-vous (READ)
    // ============================================
    @GetMapping("/all")
    public List<RendezVous> getAllRendezVous() {
        return rendezVousService.getAllRendezVous(); // Appel du service pour lister
    }

    // ============================================
    // 🔹 3. Modifier un rendez-vous par son ID (UPDATE)
    // ============================================
    @PutMapping("/update/{id}")
    public RendezVous updateRendezVous(@RequestBody RendezVous newRdv, @PathVariable Long id) {
        return rendezVousService.updateRendezVousById(newRdv, id); // Appel service pour mise à jour
    }

    // ============================================
    // 🔹 4. Supprimer un rendez-vous par ID (DELETE)
    // ============================================
    @DeleteMapping("/delete/{id}")
    public void deleteRendezVous(@PathVariable Long id) {
        rendezVousService.deleteRendezVousById(id); // Appel service pour suppression
    }
}
