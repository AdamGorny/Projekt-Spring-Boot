package com.example.projekt.Data;

import com.example.projekt.Model.But;
import com.example.projekt.Model.Klient;
import com.example.projekt.Repository.ButRepository;
import com.example.projekt.Repository.KlientRepository;
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
        Klient klient1 = new Klient("Jan", "Kowalski", "jan.kowalski@gmail.com");
        klientRepository.save(klient1);
        Klient klient2 = new Klient("Robert", "Lewandowski", "robert.lewandowski@gmail.com");
        klientRepository.save(klient2);
        Klient klient3 = new Klient("Kamil", "Stoch", "kamil.stoch@gmail.com");
        klientRepository.save(klient3);

        But but1 = new But("Nike", "Air Force 1", 45, 700);
        butRepository.save(but1);
        But but2 = new But("Nike", "Air Jordan 4", 42, 1000);
        butRepository.save(but2);
        But but3 = new But("Adidas", "Ultraboost 1.0", 40, 500);
        butRepository.save(but3);
    }
}
