package com.example.projekt.Repository;


import com.example.projekt.Model.Klient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KlientRepository extends JpaRepository<Klient,Integer> {
    public Klient findByEmail(String email);
    public Klient findById(int id);
}
