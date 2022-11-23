package com.example.backendproject.services;

import com.example.backendproject.entities.Departement;
import com.example.backendproject.entities.DetailsEquipe;
import com.example.backendproject.entities.Equipe;
import com.example.backendproject.repository.DetailsEquipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class DetailsEquipeServiceImp implements IDetailsEquipeService{

    DetailsEquipeRepository detailsEquipeRepository;


    @Override
    public List<DetailsEquipe> getAllDetailsEquipe() {
        return  detailsEquipeRepository.findAll();
    }

    @Override
    public DetailsEquipe getDetailsEquipeById(int id) {
        return detailsEquipeRepository.findById(id).orElse(null);
    }

    @Override
    public DetailsEquipe addDetailsEquipe(DetailsEquipe detailsEquipe) {
        return detailsEquipeRepository.save(detailsEquipe);
    }

    @Override
    public DetailsEquipe updateDetailsEquipe(DetailsEquipe detailsEquipe) {
        return  detailsEquipeRepository.save(detailsEquipe);
    }

    @Override
    public void deleteDetailsEquipe(int id) {
        detailsEquipeRepository.deleteById(id);
    }

    @Override
    public List<DetailsEquipe> findByThematiqueLike(String thematique) {
        return detailsEquipeRepository.findByThematiqueLike(thematique);
    }
}
