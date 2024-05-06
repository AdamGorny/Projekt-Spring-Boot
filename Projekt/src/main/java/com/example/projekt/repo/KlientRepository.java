package com.example.projekt.repo;


import com.example.projekt.klasy.Klient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KlientRepository extends JpaRepository<Klient,Integer> {
}
