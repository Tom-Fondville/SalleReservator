package com.example.sallereservator.Services;

import com.example.sallereservator.Common.Models.Reservation;
import com.example.sallereservator.Repositories.ReservationRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ReservationService {

    @Autowired
    ReservationRepostory reservationRepostory;

    public ArrayList<Reservation> GetReservationBySalleId(Long salleId){
        var response = reservationRepostory.findAll();

        var reservations = new ArrayList<Reservation>();

        response.forEach(reservation -> {
            if (reservation.salle != null && reservation.salle.id == salleId)
                reservations.add(reservation);
        });

        return reservations;
    }

    public ArrayList<Reservation> GetReservationByUserName(String userName){
        var response = reservationRepostory.findAll();

        var reservations = new ArrayList<Reservation>();

        response.forEach(reservation -> {
            if (reservation.userName == userName)
                reservations.add(reservation);
        });

        return reservations;
    }
}
