package com.example.gestionmedecin.controllers;

import com.example.gestionmedecin.entities.Medecin;
import com.example.gestionmedecin.iservices.IMedecinService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/medecins")
@RequiredArgsConstructor
@CrossOrigin
public class MedecinController {

    private final IMedecinService service;

    // CREATE
    @PostMapping
    public ResponseEntity<Medecin> create(@RequestBody Medecin m) {
        return ResponseEntity.ok(service.create(m));
    }

    // READ by id
    @GetMapping("/{id}")
    public ResponseEntity<Medecin> get(@PathVariable Long id) {
        Medecin m = service.get(id);
        return (m == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(m);
    }

    // LIST + search + pagination
    @GetMapping
    public Page<Medecin> list(@RequestParam(defaultValue = "") String q,
                              @RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "10") int size) {
        return service.list(q, PageRequest.of(page, size));
    }

    // UPDATE total (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Medecin> update(@PathVariable Long id, @RequestBody Medecin m) {
        Medecin updated = service.update(id, m);
        return (updated == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(updated);
    }

    // UPDATE partiel (PATCH)
    @PatchMapping("/{id}")
    public ResponseEntity<Medecin> patch(@PathVariable Long id, @RequestBody Medecin m) {
        Medecin updated = service.patch(id, m);
        return (updated == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(updated);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.delete(id) ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
