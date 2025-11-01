package com.example.patient.sevice;

import com.example.patient.entitie.Patient;
import com.example.patient.iservices.IPatientService;
import com.example.patient.repositories.PatientRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class PatientService implements IPatientService {
    private final PatientRepository patientRepository;
    public PatientService(PatientRepository patientRepository) {this.patientRepository =patientRepository;}

    @Override
    public Patient createPatient(Patient patient){return patientRepository.save(patient);}


    @Override
    public List<Patient>getPatient() {return patientRepository.findAll();}

    @Override
    public Patient updatePatientById(Patient patient,Long id){
        Patient toUpdate =patientRepository.findById(id).orElse(null);
        if (toUpdate != null){
            toUpdate.setNom(patient.getNom());
            toUpdate.setEmail(patient.getEmail());
            toUpdate.setTelephone(patient.getTelephone());
            return patientRepository.save(toUpdate);
        }
        return null;
    }
     @Override
    public void deletPatientById(Long id){
        patientRepository.deleteById(id);
     }

}
