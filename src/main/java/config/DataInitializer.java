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

        // Vérifier si des spécialités existent déjà
        if (specialiteRepository.count() == 0) {

            // 1️⃣ PÉDIATRIE
            Specialite pediatrie = new Specialite();
            pediatrie.setNom("Pédiatrie");
            pediatrie.setDescription("Médecine des enfants et adolescents");
            specialiteRepository.save(pediatrie);
            System.out.println("✅ Spécialité créée: Pédiatrie");

            // 2️⃣ DENTISTERIE
            Specialite dentisterie = new Specialite();
            dentisterie.setNom("Dentisterie");
            dentisterie.setDescription("Soins dentaires et bucco-dentaires");
            specialiteRepository.save(dentisterie);
            System.out.println("✅ Spécialité créée: Dentisterie");

            // 3️⃣ GYNÉCOLOGIE
            Specialite gynecologie = new Specialite();
            gynecologie.setNom("Gynécologie");
            gynecologie.setDescription("Santé reproductive et soins de la femme");
            specialiteRepository.save(gynecologie);
            System.out.println("✅ Spécialité créée: Gynécologie");

            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("✅ 3 spécialités initialisées avec succès!");
            System.out.println("   1. Pédiatrie");
            System.out.println("   2. Dentisterie");
            System.out.println("   3. Gynécologie");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        }
    }
}



