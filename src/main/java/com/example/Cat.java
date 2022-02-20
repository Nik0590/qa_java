package com.example;


import java.util.List;

public class Cat implements Predator{

    Predator predator;

    public Cat(Feline feline) {
        this.predator = feline;
    }

    @Override
    public List<String> eatMeat() throws Exception {
        return null;
    }

    @Override
    public int getKittens() {

        return getKittens(1);
    }

    @Override
    public int getKittens(int kittensCount){

        return kittensCount;
    }

    public String getSound() {
        return "Мяу";
    }

}
