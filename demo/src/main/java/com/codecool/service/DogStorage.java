package com.codecool.service;

import com.codecool.models.Dog;

import java.util.ArrayList;
import java.util.List;

public class DogStorage {
    private List<Dog> dogs;
    private static DogStorage instance;

    private DogStorage() {
        dogs = new ArrayList<>();
    }

    public static DogStorage getInstance()
    {
        if (instance == null)
            instance = new DogStorage();

        return instance;
    }

    public void addDog(Dog dog){
        dogs.add(dog);
    }

    public List<Dog> getDogs() {
        return dogs;
    }
}
