package com.example.sallereservator.Common.Models;

import jakarta.persistence.*;
import lombok.*;
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Salle {


    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Id
    private Long id;
    public String nom;
    public int nombrePlaces;
    public boolean videoProjecteur;
}
