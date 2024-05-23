package com.example.projekt.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class But {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String marka;
    private String nazwaModelu;
    private double cena;
    @ElementCollection
    private List<Double> rozmiary;

    public But(String marka, String nazwaModelu, double cena, List<Double> rozmiary) {
        this.marka = marka;
        this.nazwaModelu = nazwaModelu;
        this.cena = cena;
        this.rozmiary = rozmiary;
    }
}
