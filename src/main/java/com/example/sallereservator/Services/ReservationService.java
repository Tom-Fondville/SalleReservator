package com.example.sallereservator.Services;

import com.example.sallereservator.Common.Models.Reservation;
import com.example.sallereservator.Repositories.ReservationRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

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

    public boolean SaveReservation(Reservation resToSave){
        if (resToSave.startDate.after(resToSave.endDate)) return false;

        var reservations = reservationRepostory.findAll();
        for (var reservation : reservations) {

            if (reservation.salle.id == resToSave.salle.id){
                var calandarCheck = checkCalendar(reservation, resToSave);
                if (!calandarCheck) return false;
            }
        }

        reservationRepostory.save(resToSave);
        return true;
    }

    private boolean checkCalendar(Reservation reservation, Reservation resToSave){

        if (resToSave.startDate.before(reservation.startDate) && resToSave.endDate.before(reservation.endDate)
        || resToSave.startDate.after(reservation.startDate) && resToSave.endDate.after(reservation.endDate))
            return true;

        return false;
    }
}
