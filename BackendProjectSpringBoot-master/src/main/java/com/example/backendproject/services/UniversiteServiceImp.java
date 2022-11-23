package com.example.backendproject.services;

import com.example.backendproject.entities.Departement;
import com.example.backendproject.entities.Universite;
import com.example.backendproject.repository.DepartementRepository;
import com.example.backendproject.repository.UniversiteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class UniversiteServiceImp implements IUniversiteService {

    @Autowired
    UniversiteRepository universiteRepository;
    DepartementRepository departementRepository;
    @Override
    public List<Universite> getAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite getUniversiteById(int id) {
        return universiteRepository.findById(id).orElse(null);
    }

    @Override
    public Universite addUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite updateUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public void deleteUniversite(int id) {
        universiteRepository.deleteById(id);
    }

    @Override

    public void assignUniversiteToDepartement(int idUniversite, int idDepartement) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        Departement departement = departementRepository.findById(idDepartement).orElse(null);
        universite.getDepartements().add(departement);
        universiteRepository.save(universite);

    }
}
