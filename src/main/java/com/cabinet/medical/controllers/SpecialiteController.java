package com.cabinet.medical.controllers;

import com.cabinet.medical.entities.Specialite;
import com.cabinet.medical.iservices.ISpecialiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/specialites")
@RequiredArgsConstructor
public class SpecialiteController {

    private final ISpecialiteService specialiteService;

    // Ajouter une spécialité
    @PostMapping
    public Specialite creerSpecialite(@RequestBody Specialite specialite) {
        return specialiteService.ajouterSpecialite(specialite);
    }

    // Lister toutes les spécialités
    @GetMapping
    public List<Specialite> getAllSpecialites() {
        return specialiteService.getAllSpecialites();
    }

    // Obtenir une spécialité par ID
    @GetMapping("/{id}")
    public Specialite getSpecialiteById(@PathVariable Long id) {
        return specialiteService.getSpecialiteById(id);
    }

    // Modifier une spécialité
    @PutMapping("/{id}")
    public Specialite modifierSpecialite(@PathVariable Long id, @RequestBody Specialite specialite) {
        return specialiteService.modifierSpecialite(id, specialite);
    }

    // Supprimer une spécialité
    @DeleteMapping("/{id}")
    public void supprimerSpecialite(@PathVariable Long id) {
        specialiteService.supprimerSpecialite(id);
    }
}
