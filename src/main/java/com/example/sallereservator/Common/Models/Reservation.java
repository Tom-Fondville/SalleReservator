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
    @Column(name = "idSalle", nullable = false)
    @Id
    private Long idSalle;
    public int IdUser;
    public Date StartDate;
    public Date EndDate;
}
