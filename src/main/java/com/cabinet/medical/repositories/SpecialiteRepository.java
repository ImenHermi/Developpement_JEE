package com.cabinet.medical.repositories;

import com.cabinet.medical.entities.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialiteRepository extends JpaRepository<Specialite, Long> {
    Specialite findByNom(String nom);
}
