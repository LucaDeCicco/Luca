package com.codecool.models;

import com.codecool.enums.Breed;

import java.util.Random;

public class Dog {
    private String name;
    private int age;
    private String breed;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
        this.breed = String.valueOf(getRandomBreed());
    }

    public Dog(String name, int age, String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    private Breed getRandomBreed(){
        Breed [] breeds = Breed.values();
        Random random = new Random();
        int index = random.nextInt(breeds.length);
        return breeds[index];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = String.valueOf(breed);
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", breed=" + breed +
                '}';
    }
}
