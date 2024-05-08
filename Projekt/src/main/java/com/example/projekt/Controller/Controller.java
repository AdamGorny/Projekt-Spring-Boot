package com.example.projekt.Controller;

import com.example.projekt.Model.But;
import com.example.projekt.Repository.ButRepository;
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

    @GetMapping
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
}
