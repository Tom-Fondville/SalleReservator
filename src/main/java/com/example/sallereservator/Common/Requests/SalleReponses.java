package com.example.sallereservator.Common.Requests;

import com.example.sallereservator.Common.Models.Salle;

public class SalleReponses extends Salle {
    public boolean isDisponible;

    public SalleReponses(Salle salle, boolean isDisponible) {
        super(salle.id, salle.nom, salle.nombrePlaces, salle.videoProjecteur, salle.pictureUrl);
        this.isDisponible = isDisponible;
    }
}
