package com.example.projekt.Controller;

import com.example.projekt.Model.But;
import com.example.projekt.Model.Klient;
import com.example.projekt.Model.Zamowienie;
import com.example.projekt.Repository.ButRepository;
import com.example.projekt.Repository.KlientRepository;
import com.example.projekt.Repository.ZamowienieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private ButRepository butRepository;
    @Autowired
    private KlientRepository klientRepository;
    @Autowired
    private ZamowienieRepository zamowienieRepository;

    @GetMapping("/baza")
    public String zwrocButy(Model model) {
      List<But> butyLista = butRepository.findAll();
      model.addAttribute("listaButow", butyLista);
      return "listaButow";
    }

    @PostMapping("/usunBut")
    public String usunBut(@RequestParam Integer id) {
        butRepository.deleteById(id);
        return "redirect:";
    }

    @PostMapping("/dodajBut")
    public String dodajBut(@RequestParam String marka, @RequestParam String nazwaModelu,
                           @RequestParam double rozmiar, @RequestParam double cena) {
        butRepository.save(new But(marka, nazwaModelu, rozmiar, cena));
        return "redirect:";
    }

    @PostMapping("/edytujBut")
    public String edytujBut(@RequestParam Integer id, Model model) {
        But but = butRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Nieprawidłowe ID buta"));
        model.addAttribute("but", but);
        return "edycjaButa";
    }

    @PostMapping("/zapiszEdycjeButa")
    public String zapiszEdycjeButa(@RequestParam Integer id, @RequestParam String marka,
                                   @RequestParam String nazwaModelu, @RequestParam double rozmiar,
                                   @RequestParam double cena) {
        But but = butRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Nieprawidłowe ID buta"));
        but.setMarka(marka);
        but.setNazwaModelu(nazwaModelu);
        but.setRozmiar(rozmiar);
        but.setCena(cena);
        butRepository.save(but);
        return "redirect:";
    }

    @GetMapping
    public String loginPage(){
        return "start";
    }
    @PostMapping("/logowanie")
    public String logowanie(@RequestParam String email, @RequestParam String haslo, Model model){
        if (email.equals("Admin") && haslo.equals("admin123")){
              List<But> butyLista = butRepository.findAll();
              model.addAttribute("listaButow", butyLista);
              return "listaButow";
        }
        else {
            Klient klient = klientRepository.findByEmail(email);
            if (klient == null)
                throw (new IllegalArgumentException("Nieprawidłowy email"));

            else if (klient.getHaslo().equals(haslo)) {
                model.addAttribute("zalogowanyKlient", klient);
                List<Zamowienie> zamowienia = zamowienieRepository.ZnajdzPoKliencie(klient.getId());
                model.addAttribute("zamowienia", zamowienia);
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

}
