package com.example.projekt;

import com.example.projekt.klasy.But;
import com.example.projekt.klasy.Klient;
import com.example.projekt.repo.ButRepository;
import com.example.projekt.repo.KlientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final ButRepository butRepository;
    private final KlientRepository klientRepository;

    public DataLoader(ButRepository butRepository, KlientRepository klientRepository){
        this.butRepository = butRepository;
        this.klientRepository = klientRepository;
    }

    public void run(String... args) throws Exception {
        Klient klient1 = new Klient("Jan", "Kowalski");
        klientRepository.save(klient1);
        Klient klient2 = new Klient("Robert", "Lewandowski");
        klientRepository.save(klient2);
        Klient klient3 = new Klient("Kamil", "Stoch");
        klientRepository.save(klient3);

        But but1 = new But("Nike", "Air Force 1");
        butRepository.save(but1);
        But but2 = new But("Nike", "Air Jordan 4");
        butRepository.save(but2);
        But but3 = new But("Adidas", "Ultraboost 1.0");
        butRepository.save(but3);
    }
}
