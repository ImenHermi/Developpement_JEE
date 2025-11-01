package com.cabinet.medical.services;

import com.cabinet.medical.entities.Specialite;
import com.cabinet.medical.iservices.ISpecialiteService;
import com.cabinet.medical.repositories.SpecialiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecialiteService implements ISpecialiteService {

    private final SpecialiteRepository specialiteRepository;

    @Override
    public Specialite ajouterSpecialite(Specialite specialite) {
        return specialiteRepository.save(specialite);
    }

    @Override
    public List<Specialite> getAllSpecialites() {
        return specialiteRepository.findAll();
    }

    @Override
    public Specialite getSpecialiteById(Long id) {
        return specialiteRepository.findById(id).orElse(null);
    }

    @Override
    public Specialite modifierSpecialite(Long id, Specialite specialite) {
        Specialite existante = specialiteRepository.findById(id).orElse(null);
        if (existante != null) {
            existante.setNom(specialite.getNom());
            existante.setDescription(specialite.getDescription());
            return specialiteRepository.save(existante);
        }
        return null;
    }

    @Override
    public void supprimerSpecialite(Long id) {
        specialiteRepository.deleteById(id);
    }
}
