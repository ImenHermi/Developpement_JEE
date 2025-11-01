package com.example.gestionmedecin.repositories;

import com.example.gestionmedecin.entities.Medecin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Page<Medecin> findByNomContainingIgnoreCase(String q, Pageable pageable);
}
