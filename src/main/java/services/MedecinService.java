package com.example.gestionmedecin.services;

import com.example.gestionmedecin.entities.Medecin;
import com.example.gestionmedecin.iservices.IMedecinService;
import com.example.gestionmedecin.repositories.MedecinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedecinService implements IMedecinService {

    private final MedecinRepository repo;

    @Override
    public Medecin create(Medecin m) {
        return repo.save(m);
    }

    @Override
    public Medecin get(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Page<Medecin> list(String q, Pageable pageable) {
        return (q == null || q.isBlank())
                ? repo.findAll(pageable)
                : repo.findByNomContainingIgnoreCase(q, pageable);
    }

    @Override
    public Medecin update(Long id, Medecin m) { // PUT
        Medecin ex = repo.findById(id).orElse(null);
        if (ex == null) return null;
        ex.setNom(m.getNom());
        ex.setEmail(m.getEmail());
        ex.setSpecialite(m.getSpecialite());
        // rendezVousList gérée côté RendezVous (mappedBy)
        return repo.save(ex);
    }

    @Override
    public Medecin patch(Long id, Medecin m) { // PATCH
        Medecin ex = repo.findById(id).orElse(null);
        if (ex == null) return null;
        if (m.getNom() != null) ex.setNom(m.getNom());
        if (m.getEmail() != null) ex.setEmail(m.getEmail());
        if (m.getSpecialite() != null) ex.setSpecialite(m.getSpecialite());
        return repo.save(ex);
    }

    @Override
    public boolean delete(Long id) {
        if (!repo.existsById(id)) return false;
        repo.deleteById(id);
        return true;
    }
}
