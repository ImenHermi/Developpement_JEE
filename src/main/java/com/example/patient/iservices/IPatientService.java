package com.example.patient.iservices;
import com.example.patient.entitie.Patient;
import java.util.List;

public interface IPatientService {
    Patient createPatient(Patient patient);
    List<Patient>getPatient();
    Patient updatePatientById (Patient patient,Long id);
    void deletPatientById(Long id);
}
