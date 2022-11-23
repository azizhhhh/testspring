package com.example.backendproject.services;

import com.example.backendproject.entities.Departement;
import com.example.backendproject.entities.Option;
import com.example.backendproject.repository.DepartementRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartementServiceImp implements IDepartementService {
    //injecter repository dans service
    DepartementRepository departementRepository;

    @Override
    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

    @Override
    public Departement getDepartementById(int id) {
        return departementRepository.findById(id).orElse(null);
    }

    @Override
    public Departement addDepartement(Departement departement) {
        return departementRepository.save(departement);
    }

    @Override
    public Departement updateDepartement(Departement departement) {
        return departementRepository.save(departement);
    }

    @Override
    public void deleteDepartement(int id) {
        departementRepository.deleteById(id);
    }

    @Override
    public List<Departement> retrieveDepartementByOptionEtudiant(Option option) {
        return departementRepository.retrieveDepartementByOptionEtudiant(option);
    }
}
