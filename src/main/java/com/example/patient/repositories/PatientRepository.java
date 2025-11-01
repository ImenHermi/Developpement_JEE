package com.example.patient.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.patient.entitie.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
}
