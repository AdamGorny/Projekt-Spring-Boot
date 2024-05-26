package com.example.projekt.Controller;

import com.example.projekt.Model.But;
import com.example.projekt.Model.Klient;
import com.example.projekt.Model.Zamowienie;
import com.example.projekt.Repository.ButRepository;
import com.example.projekt.Repository.KlientRepository;
import com.example.projekt.Repository.ZamowienieRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Controller
public class Controller {
    private final ButRepository butRepository;
    private final KlientRepository klientRepository;
    private final ZamowienieRepository zamowienieRepository;

    public Controller(ButRepository butRepository, KlientRepository klientRepository, ZamowienieRepository zamowienieRepository) {
        this.butRepository = butRepository;
        this.klientRepository = klientRepository;
        this.zamowienieRepository = zamowienieRepository;
    }

    @GetMapping("/baza")
    public String zwrocButy(Model model) {
      List<But> butyLista = butRepository.findAll();
      model.addAttribute("listaButow", butyLista);
      return "listaButow";
    }

    @PostMapping("/usunBut")
    public String usunBut(@RequestParam Integer id) {
        zamowienieRepository.UsunPoId(id);
        butRepository.deleteById(id);
        return "redirect:/baza";
    }

    @PostMapping("/dodajBut")
    public String dodajBut(@RequestParam String marka, @RequestParam String nazwaModelu,
                           @RequestParam double cena, @RequestParam String rozmiary) {

        butRepository.save(new But(marka, nazwaModelu, cena, rozmiaryDoListy(rozmiary)));
        return "redirect:/baza";
    }

    @PostMapping("/edytujBut")
    public String edytujBut(@RequestParam Integer id, Model model) {
        But but = butRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Nieprawidłowe ID buta"));
        model.addAttribute("but", but);
        return "edycjaButa";
    }

    @PostMapping("/zapiszEdycjeButa")
    public String zapiszEdycjeButa(@RequestParam Integer id, @RequestParam String marka,
                                   @RequestParam String nazwaModelu, @RequestParam double cena,
                                   @RequestParam String rozmiary) {
        But but = butRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Nieprawidłowe ID buta"));
        but.setMarka(marka);
        but.setNazwaModelu(nazwaModelu);
        but.setCena(cena);
        but.setRozmiary(rozmiaryDoListy(rozmiary));
        butRepository.save(but);
        return "redirect:/baza";
    }

    @GetMapping
    public String loginPage(){
        return "start";
    }
    @PostMapping("/logowanie")
    public String logowanie(@RequestParam String email, @RequestParam String haslo, Model model){
        List<But> butyLista = butRepository.findAll();
        model.addAttribute("listaButow", butyLista);
        if (email.equals("Admin") && haslo.equals("admin123")){
              return "listaButow";
        }
        else {
            Klient klient = klientRepository.findByEmail(email);
            if (klient == null)
                throw (new IllegalArgumentException("Nieprawidłowy email"));

            else if (klient.getHaslo().equals(haslo)) {
                pobierzModel(model, klient);
                return "stronaKlienta";
            } else
                throw (new IllegalArgumentException("Nieprawidłowe hasło"));
        }
    }
    @GetMapping("/utworzKonto")
    public String utworzKonto(){
        return "noweKonto";
    }
    @PostMapping("/tworzenieKonta")
    public String tworzenieKonta(@RequestParam String imie, @RequestParam String nazwisko,
                                 @RequestParam String email, @RequestParam String haslo){
        Klient klient = new Klient(imie,nazwisko,email,haslo);
        klientRepository.save(klient);
        return "start";
    }

    @PostMapping("/dodajZamowienie")
    public String dodajZamowienie(@RequestParam int klient_id, @RequestParam int but_id, @RequestParam Double rozmiar,
                                  Model model){
        Klient klient = klientRepository.findById(klient_id);
        But but = butRepository.findById(but_id);
        Zamowienie zam = new Zamowienie(klient, but, rozmiar);
        zamowienieRepository.save(zam);
        pobierzModel(model, klient);
        return "stronaKlienta";
    }
    @GetMapping("/wyloguj")
    public String wyloguj(){
        return "redirect:";
    }

    private void pobierzModel(Model model, Klient klient) {
        List<Zamowienie> zamowienia = zamowienieRepository.ZnajdzPoKliencie(klient.getId());
        model.addAttribute("zalogowanyKlient", klient);
        model.addAttribute("zamowienia", zamowienia);

        List<But> butyLista = butRepository.findAll();
        model.addAttribute("listaButow", butyLista);
    }

    private List<Double> rozmiaryDoListy(String rozmiary) {
        return  Arrays.stream(rozmiary.trim()
                        .split("\\s*,\\s*"))
                        .map(Double::parseDouble)
                        .sorted()
                        .collect(Collectors.toList());
    }

}
