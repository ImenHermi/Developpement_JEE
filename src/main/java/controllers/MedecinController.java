package com.gestionmedecin.controllers;

import com.gestionmedecin.entities.Medecin;
import com.gestionmedecin.entities.RendezVous;
import com.gestionmedecin.iservices.IMedecinService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/medecins")
@RequiredArgsConstructor
@CrossOrigin
public class MedecinController {

    private final IMedecinService service;

    // CREATE
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Medecin create(@RequestBody Medecin m) {
        return service.create(m);
    }

    // READ one
    @GetMapping("/{id}")
    public Medecin get(@PathVariable Long id) {
        return service.get(id);
    }

    // READ page
    @GetMapping
    public Page<Medecin> list(@RequestParam(defaultValue = "") String q,
                              @RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "10") int size) {
        return service.list(q, PageRequest.of(page, size));
    }

    // UPDATE (PUT - total)
    @PutMapping("/{id}")
    public Medecin update(@PathVariable Long id, @RequestBody Medecin m) {
        return service.update(id, m);
    }

    // PATCH (partiel)
    @PatchMapping("/{id}")
    public Medecin patch(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        return service.patch(id, updates);
    }

    // DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    // PUSH: ajouter un rendez-vous au médecin
    @PostMapping("/{id}/rendezvous")
    public Medecin pushRendezVous(@PathVariable Long id, @RequestBody RendezVous rv) {
        return service.pushRendezVous(id, rv);
    }

    // PULL: retirer un rendez-vous du médecin
    @DeleteMapping("/{id}/rendezvous/{rvId}")
    public Medecin pullRendezVous(@PathVariable Long id, @PathVariable Long rvId) {
        return service.pullRendezVous(id, rvId);
    }

    // ---- Handlers d'erreurs simples
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> notFound(NoSuchElementException ex) {
        return Map.of("error", ex.getMessage());
    }
}
