package com.codecool.controller;

import com.codecool.models.Dog;
import com.codecool.service.DogCreator;
import com.codecool.service.DogStorage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class DogController {

    @GetMapping
    public String index(){
        return "Hello";
    }
    @GetMapping("allDogs")
    public List<Dog> getAllStoredDogs(Model model){
        DogStorage dogStorage = DogStorage.getInstance();
        List<Dog> dogs = dogStorage.getDogs();
        return dogs;
    }

    @GetMapping("getRandomDog")
    public Dog getRandomDog(Model model){
        DogCreator dogCreator = new DogCreator();
        Dog dog = dogCreator.createRandomDog();
        DogStorage dogStorage = DogStorage.getInstance();
        return dog;
    }

}
