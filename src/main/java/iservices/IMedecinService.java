package com.gestionmedecin.iservices;

import com.gestionmedecin.entities.Medecin;
import com.gestionmedecin.entities.RendezVous;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface IMedecinService {
    Medecin create(Medecin m);
    Medecin get(Long id);
    Page<Medecin> list(String q, Pageable pageable);
    Medecin update(Long id, Medecin m);
    void delete(Long id);

    // PATCH (mise à jour partielle)
    Medecin patch(Long id, Map<String, Object> updates);

    // push/pull sur la liste des rendez-vous
    Medecin pushRendezVous(Long medecinId, RendezVous rv);          // POST /{id}/rendezvous
    Medecin pullRendezVous(Long medecinId, Long rendezVousId);      // DELETE /{id}/rendezvous/{rvId}
}
