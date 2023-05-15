package com.example.sallereservator.Repositories;

import com.example.sallereservator.Common.Models.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepostory extends CrudRepository<Reservation,Long > {}
