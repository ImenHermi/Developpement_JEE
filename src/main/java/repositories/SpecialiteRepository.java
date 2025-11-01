// repositories/SpecialiteRepository.java
package com.example.gestionmedecin.repositories;
import com.example.gestionmedecin.entities.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SpecialiteRepository extends JpaRepository<Specialite, Long> {}
