package com.codecool.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@SpringBootApplication
public class DogController {

    @GetMapping
    public void doGet(){}


    @PostMapping
    public void doPost(){

    }
}
