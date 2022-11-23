package com.example.backendproject.controller;

import com.example.backendproject.entities.DetailsEquipe;
import com.example.backendproject.entities.Etudiant;
import com.example.backendproject.entities.Option;
import com.example.backendproject.services.IEtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EtudiantController {


    IEtudiantService iEtudiantService;

    @GetMapping
    public String SayHello(){
        return "Hello";
    }

    @GetMapping("/AllEtudiant")
    @ResponseBody
    public List<Etudiant> getAllEtudiant(){
        return iEtudiantService.getAllEtudiants();
    }

    @PostMapping("/addEtudiant")
    @ResponseBody
    public Etudiant addEtudiant (@RequestBody Etudiant etudiant){
        return iEtudiantService.addEtudiant(etudiant);
    }



    @PutMapping("/updateEtudiant")
    private Etudiant updateEtudiant(@RequestBody Etudiant etudiant)
    {
        iEtudiantService.updateEtudiant(etudiant);
        return etudiant;
    }



    @DeleteMapping("/deleteEtudiant/{id}")
    private void deleteEtudiant(@PathVariable("id") int id)
    {
        iEtudiantService.deleteEtudiant(id);
    }

    @GetMapping("/getEtudiantById/{id}")
    @ResponseBody
    public Etudiant  getEtudiantById(@PathVariable("id") int id){
      return   iEtudiantService.getEtudiantById(id);
    }


    @GetMapping("/getEtudiantByPrenom/{prenomE}")
    public Etudiant getEtudiantByPrenom(@PathVariable("prenomE")String prenomE){
        return iEtudiantService.findPrenomEContains(prenomE);
    }


    @PutMapping("/updateEtudiantByOption/{option}/{idEtudiant}")
    public void updateEtudiantByOption(@PathVariable("option") Option option , @PathVariable("idEtudiant") int idEtudiant){
         iEtudiantService.updateEtudiantByOption(option,idEtudiant);
    }

    @GetMapping("/retrieveEtudiantByEquipeThematique/{thematique}")
    List<Etudiant> retrieveEtudiantByEquipeThematique (@PathVariable("thematique") String thematique){
      return   iEtudiantService.retrieveEtudiantByEquipeThematique(thematique);
    }
    @PutMapping ("/assignEtudiantToDeppartement/{idEtudiant}/{idDepartement}")
    public void assignEtudiantToDepartement(@PathVariable("idEtudiant") int idEtudiant,@PathVariable("idDepatement")  int idDepartement){
        iEtudiantService.assignEtudiantToDepartement(idEtudiant,idDepartement);
    }

}
