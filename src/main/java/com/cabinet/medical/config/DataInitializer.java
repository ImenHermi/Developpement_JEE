package com.cabinet.medical.config;

import com.cabinet.medical.entities.Specialite;
import com.cabinet.medical.repositories.SpecialiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final SpecialiteRepository specialiteRepository;

    @Override
    public void run(String... args) throws Exception {
        if (specialiteRepository.count() == 0) {

            Specialite pediatrie = new Specialite();
            pediatrie.setNom("Pédiatrie");
            pediatrie.setDescription("Médecine des enfants et adolescents");
            specialiteRepository.save(pediatrie);

            Specialite dentisterie = new Specialite();
            dentisterie.setNom("Dentisterie");
            dentisterie.setDescription("Soins dentaires et bucco-dentaires");
            specialiteRepository.save(dentisterie);

            Specialite gynecologie = new Specialite();
            gynecologie.setNom("Gynécologie");
            gynecologie.setDescription("Santé reproductive et soins de la femme");
            specialiteRepository.save(gynecologie);

            System.out.println("✅ 3 spécialités créées : Pédiatrie, Dentisterie, Gynécologie");
        }
    }
}
