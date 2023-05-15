package com.example.sallereservator.Common.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Id
    public Long id;

    @OneToOne
    public Salle salle;
    public String userName;
    public Date startDate;
    public Date endDate;
}
