package com.example.rendezvous.Repositories;

import com.example.rendezvous.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Spécifier que c'est un repository Spring Data JPA
public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {
    // Étendre JpaRepository pour fournir des opérations CRUD pour l'entité RendezVous
}
