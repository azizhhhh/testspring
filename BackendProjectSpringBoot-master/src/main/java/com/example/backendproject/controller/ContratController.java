package com.example.backendproject.controller;

import com.example.backendproject.entities.Contrat;
import com.example.backendproject.services.IContratService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ContratController {

    IContratService iContratService;


    @GetMapping("/AllContrats")
    @ResponseBody
    public List<Contrat> getAllContrats(){
        return iContratService.getAllContrats();
    }

    @PostMapping("/addContrat")
    @ResponseBody
    public Contrat addContrat(@RequestBody Contrat contrat){
        return iContratService.addContrat(contrat);
    }


    @PutMapping("/updateContrat")
    @ResponseBody
    public Contrat updateContrat(@RequestBody Contrat contrat){
        return iContratService.updateContrat(contrat);
    }


    @DeleteMapping("/deleteContrat/{id}")
    @ResponseBody
    public void deleteContrat(@PathVariable("id")int id){
        iContratService.deleteContrat(id);
    }

    @GetMapping("/getContratById/{id}")
    @ResponseBody
    public Contrat getContratById(@PathVariable("id")int id){
        return iContratService.getContratById(id);
    }
}
