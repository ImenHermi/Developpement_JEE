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

    // POST - Créer une nouvelle spécialité
    @PostMapping
    public Specialite creerSpecialite(@RequestBody Specialite specialite) {
        return specialiteService.ajouterSpecialite(specialite);
    }

    // GET - Afficher toutes les spécialités
    @GetMapping
    public List<Specialite> getAllSpecialites() {
        return specialiteService.getAllSpecialites();
    }

    // GET - Afficher une spécialité par ID
    @GetMapping("/{id}")
    public Specialite getSpecialiteById(@PathVariable Long id) {
        return specialiteService.getSpecialiteById(id);
    }

    // PUT - Modifier une spécialité
    @PutMapping("/{id}")
    public Specialite modifierSpecialite(@PathVariable Long id, @RequestBody Specialite specialite) {
        return specialiteService.modifierSpecialite(id, specialite);
    }

    // DELETE - Supprimer une spécialité
    @DeleteMapping("/{id}")
    public void supprimerSpecialite(@PathVariable Long id) {
        specialiteService.supprimerSpecialite(id);
    }