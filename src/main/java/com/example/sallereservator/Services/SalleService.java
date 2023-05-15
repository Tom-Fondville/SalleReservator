package com.example.sallereservator.Services;

import com.example.sallereservator.Common.Requests.SalleReponses;
import com.example.sallereservator.Repositories.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class SalleService {

    @Autowired
    SalleRepository salleRepository;

    @Autowired
    ReservationService reservationService;

    public ArrayList<SalleReponses> GetSalles(){
        var salles = salleRepository.findAll();

        ArrayList<SalleReponses> salleReponses = new ArrayList<>();
        for (var salle : salles) {
            salleReponses.add(new SalleReponses(salle, reservationService.IsSalleDisponible(salle.id)));
        }

        return salleReponses;
    }
}
