package com.example.projekt.Data;

import com.example.projekt.Model.But;
import com.example.projekt.Model.Klient;
import com.example.projekt.Model.Zamowienie;
import com.example.projekt.Repository.ButRepository;
import com.example.projekt.Repository.KlientRepository;
import com.example.projekt.Repository.ZamowienieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    private final ButRepository butRepository;
    private final KlientRepository klientRepository;
    private final ZamowienieRepository zamowienieRepository;

    public DataLoader(ButRepository butRepository, KlientRepository klientRepository, ZamowienieRepository zamowienieRepository){
        this.butRepository = butRepository;
        this.klientRepository = klientRepository;
        this.zamowienieRepository = zamowienieRepository;
    }

    public void run(String... args) throws Exception {
        But but1 = new But("Nike", "Air Force 1", 700, List.of(45.,42.5,43.));
        butRepository.save(but1);
        But but2 = new But("Nike", "Air Jordan 4", 1000, List.of(39.5,40.,40.5));
        butRepository.save(but2);
        But but3 = new But("Adidas", "Ultraboost 1.0", 500, List.of(45.,46.));
        butRepository.save(but3);

        Klient klient1 = new Klient("Jan", "Kowalski", "jan.kowalski@gmail.com","jk123");
        klientRepository.save(klient1);
        Klient klient2 = new Klient("Robert", "Lewandowski", "robert.lewandowski@gmail.com","rl9");
        klientRepository.save(klient2);
        Klient klient3 = new Klient("Kamil", "Stoch", "kamil.stoch@gmail.com","skoki1234");
        klientRepository.save(klient3);

        Zamowienie zam1 = new Zamowienie(klient1, but1, 47.5);
        zamowienieRepository.save(zam1);
        Zamowienie zam2 = new Zamowienie(klient1, but2, 49.0);
        zamowienieRepository.save(zam2);
        Zamowienie zam3 = new Zamowienie(klient1, but3, 44.0);
        zamowienieRepository.save(zam3);

    }
}
