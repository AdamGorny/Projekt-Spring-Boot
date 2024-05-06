package com.example.projekt.klasy;

import jakarta.persistence.*;

@Entity
public class Klient {
    @Id @GeneratedValue
    private int id;

    private String imie;
    private String nazwisko;
    //@ManyToOne(cascade = CascadeType.ALL)
    //private But but;

    public Klient(String imie, String nazwisko){
        this.imie = imie;
        this.nazwisko = nazwisko;
    }
    public Klient(){}

    public int getId(){ return id;}

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String toString(){
        return this.imie + " " + this.nazwisko;
    }
}
