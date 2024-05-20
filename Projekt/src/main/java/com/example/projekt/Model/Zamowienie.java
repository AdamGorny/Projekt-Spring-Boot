package com.example.projekt.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Zamowienie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_zam;
    @ManyToOne
    @JoinColumn(name = "klient_id")
    private Klient klient;
    @ManyToOne
    @JoinColumn(name = "but_id")
    private But but;
    private int rozmiar;
    public Zamowienie(Klient klient, But but, int rozmiar){
        this.klient = klient;
        this.but = but;
        this.rozmiar = rozmiar;
    }
}
