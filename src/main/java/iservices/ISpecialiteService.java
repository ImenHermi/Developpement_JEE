package com.cabinet.medical.iservices;

import com.cabinet.medical.entities.Specialite;
import java.util.List;

public interface ISpecialiteService {
    Specialite ajouterSpecialite(Specialite specialite);
    List<Specialite> getAllSpecialites();
    Specialite getSpecialiteById(Long id);
    Specialite modifierSpecialite(Long id, Specialite specialite);
    void supprimerSpecialite(Long id);
}

