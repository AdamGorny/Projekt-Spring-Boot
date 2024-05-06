package com.example.projekt.klasy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class But {
    @Id @GeneratedValue
    private int id;

    private String marka;
    private String nazwaModelu;

    public But(String marka, String nazwaModelu){
        this.marka = marka;
        this.nazwaModelu = nazwaModelu;
    }
    public But(){}

    public void setId(int id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getNazwaModelu() {
        return nazwaModelu;
    }

    public void setNazwaModelu(String nazwaModelu) {
        this.nazwaModelu = nazwaModelu;
    }

    public String toString(){
        return this.marka + " " + this.nazwaModelu;
    }
}
