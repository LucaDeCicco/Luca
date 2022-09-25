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
import java.util.Objects;

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
        return dog;
    }


    @PostMapping("addDog/{dogName}/{dogAge}/{dogBreed}")
    public void addNewDog(@PathVariable(name="dogName") String name,
                          @PathVariable(name="dogAge") String age,
                          @PathVariable(name="dogBreed") String breed
                          ){
        DogCreator dogCreator = new DogCreator();
        Dog dog = new Dog(name,Integer.parseInt(age),breed);
        DogStorage dogStorage = DogStorage.getInstance();
        dogStorage.addDog(dog);
    }

    @PutMapping("/updateDog/{dogName}/{dogAge}/{dogBreed}")
    public void updateDog(@PathVariable(name="dogName") String name,
                          @PathVariable(name="dogAge") String age,
                          @PathVariable(name="dogBreed") String breed
    ){
        DogStorage dogStorage = DogStorage.getInstance();
        List<Dog> dogs = dogStorage.getDogs();
        for (Dog dog : dogs) {
            if (Objects.equals(dog.getName(), name)){
                dog.setAge(Integer.parseInt(age));
                dog.setBreed(breed);
            }
        }
    }

}
