package com.example.projekt.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    //private double rozmiar;
    private double cena;

    public But(String marka, String nazwaModelu, double cena) {
        this.marka = marka;
        this.nazwaModelu = nazwaModelu;
        this.cena = cena;
    }
}
