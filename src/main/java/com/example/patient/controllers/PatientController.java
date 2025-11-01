package com.example.patient.controllers;
import com.example.patient.entitie.Patient;
import com.example.patient.iservices.IPatientService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping()
public class PatientController {
    private final IPatientService iPatientService;
    public PatientController(IPatientService iPatientService) {this.iPatientService = iPatientService;}

    @PostMapping("/creat")
    public Patient saveNew(@RequestBody Patient patient){return iPatientService.createPatient(patient);}

    @PutMapping("/update/{id}")
    public Patient updateById(@RequestBody Patient patient, @PathVariable("id") Long id){
        return iPatientService.updatePatientById(patient ,id);

    }
    @GetMapping("/all")
    public List<Patient>getAllPatient(){return iPatientService.getPatient();}

    @DeleteMapping("/delete{id}")
    public void deletePatientById(@PathVariable("id") Long id ){iPatientService.deletPatientById(id);}

}
