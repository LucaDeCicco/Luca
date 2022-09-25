package com.codecool.service;

import com.codecool.models.Dog;

import java.util.Random;

public class DogCreator {
    public DogCreator() {
    }

    public Dog createRandomDog(){
        String[] dogNames = {"Azo","Bob","Mei","Osc"};
        Random random = new Random();
        Dog dog = new Dog(dogNames[random.nextInt(dogNames.length)], random.nextInt(21));
        DogStorage dogStorage = DogStorage.getInstance();
        dogStorage.addDog(dog);
        return dog;
    }
}
