package com.example.projekt;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping
    public String test(){ return "start";}
}
