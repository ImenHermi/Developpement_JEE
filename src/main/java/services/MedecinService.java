package com.gestionmedecin.services;

import com.gestionmedecin.entities.Medecin;
import com.gestionmedecin.entities.RendezVous;
import com.gestionmedecin.iservices.IMedecinService;
import com.gestionmedecin.repositories.MedecinRepository;
import com.gestionmedecin.repositories.RendezVousRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class MedecinService implements IMedecinService {

    private final MedecinRepository medecinRepository;
    private final RendezVousRepository rendezVousRepository;

    @Override
    public Medecin create(Medecin m) {
        return medecinRepository.save(m);
    }

    @Override
    @Transactional(readOnly = true)
    public Medecin get(Long id) {
        return medecinRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Medecin " + id + " introuvable"));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Medecin> list(String q, Pageable pageable) {
        if (q == null || q.isBlank()) return medecinRepository.findAll(pageable);
        return medecinRepository.findByNomContainingIgnoreCaseOrEmailContainingIgnoreCase(q, q, pageable);
    }

    @Override
    public Medecin update(Long id, Medecin m) {
        Medecin db = get(id);
        db.setNom(m.getNom());
        db.setEmail(m.getEmail());
        db.setSpecialite(m.getSpecialite());
        // si tu veux écraser la liste entière (optionnel)
        if (m.getRendezVousList() != null) {
            db.getRendezVousList().clear();
            for (RendezVous rv : m.getRendezVousList()) {
                rv.setMedecin(db);
                db.getRendezVousList().add(rv);
            }
        }
        return db;
    }

    @Override
    public void delete(Long id) {
        medecinRepository.deleteById(id);
    }

    @Override
    public Medecin patch(Long id, Map<String, Object> updates) {
        Medecin db = get(id);
        // patch simple: champs scalaires de Medecin (nom, email)
        updates.forEach((k, v) -> {
            if (v == null) return;
            switch (k) {
                case "nom" -> db.setNom(v.toString());
                case "email" -> db.setEmail(v.toString());
                // pour patcher d’autres champs scalaires, ajouter ici
                default -> {
                    // fallback (réflexion) si besoin
                    try {
                        Field f = Medecin.class.getDeclaredField(k);
                        f.setAccessible(true);
                        f.set(db, v);
                    } catch (NoSuchFieldException | IllegalAccessException ignored) { }
                }
            }
        });
        return db;
    }

    @Override
    public Medecin pushRendezVous(Long medecinId, RendezVous rv) {
        Medecin db = get(medecinId);
        rv.setMedecin(db);
        db.getRendezVousList().add(rv);
        rendezVousRepository.save(rv);
        return db;
    }

    @Override
    public Medecin pullRendezVous(Long medecinId, Long rendezVousId) {
        Medecin db = get(medecinId);
        RendezVous rv = rendezVousRepository.findById(rendezVousId)
                .orElseThrow(() -> new NoSuchElementException("RendezVous " + rendezVousId + " introuvable"));
        if (rv.getMedecin() == null || !rv.getMedecin().getId().equals(medecinId)) {
            throw new NoSuchElementException("Ce rendez-vous n'appartient pas au médecin " + medecinId);
        }
        db.getRendezVousList().removeIf(r -> r.getId().equals(rendezVousId));
        rendezVousRepository.delete(rv); // orphanRemoval gère aussi, mais on supprime explicitement
        return db;
    }
}
