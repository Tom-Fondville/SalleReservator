package com.example.sallereservator.Controllers;

import com.example.sallereservator.Common.Models.Reservation;
import com.example.sallereservator.Common.Models.Salle;
import com.example.sallereservator.Repositories.ReservationRepostory;
import com.example.sallereservator.Services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "reservation")
public class ReservationController {

    @Autowired
    ReservationRepostory reservationRepostory;

    @Autowired
    ReservationService reservationService;


    @GetMapping()
    public Iterable<Reservation> GetReservations(){
        return reservationRepostory.findAll();
    }

    @GetMapping(path = "/salle/{id}")
    public ResponseEntity<ArrayList<Reservation>> GetSalle(@PathVariable Long id){
        return new ResponseEntity<>(reservationService.GetReservationBySalleId(id), HttpStatus.OK);
    }

    @GetMapping(path = "/user/{name}")
    public ResponseEntity<ArrayList<Reservation>> GetSalle(@PathVariable String name){
        return new ResponseEntity<>(reservationService.GetReservationByUserName(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Reservation> CreateSalle(@RequestBody Reservation reservation){
        reservationRepostory.save(reservation);
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }

}
