package com.example.sallereservator.Controllers;

import com.example.sallereservator.Common.Models.Salle;
import com.example.sallereservator.Common.Requests.SalleReponses;
import com.example.sallereservator.Repositories.SalleRepository;
import com.example.sallereservator.Services.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "salle")
public class SalleController {

    @Autowired
    SalleRepository salleRepository;

    @Autowired
    SalleService salleService;


    @GetMapping()
    public Iterable<SalleReponses> GetAllSalles(){
        return salleService.GetSalles();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Salle> GetSalle(@PathVariable long id){
        var sale = salleRepository.findById(id);
        return sale.map(salle -> new ResponseEntity<>(salle, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Salle> CreateSalle(@RequestBody Salle salle){
        salleRepository.save(salle);
        return new ResponseEntity<>(salle, HttpStatus.OK);
    }

}
