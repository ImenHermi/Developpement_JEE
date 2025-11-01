package com.example.gestionmedecin.iservices;

import com.example.gestionmedecin.entities.Medecin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMedecinService {
    Medecin create(Medecin m);
    Medecin get(Long id);                   // null si introuvable
    Page<Medecin> list(String q, Pageable pageable);
    Medecin update(Long id, Medecin m);     // null si introuvable (PUT)
    Medecin patch(Long id, Medecin m);      // null si introuvable (PATCH)
    boolean delete(Long id);                // false si introuvable
}
