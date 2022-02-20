package com.example;

import java.util.List;

public class Lion extends Animal implements Predator {

    boolean hasMane;

    public Lion(String sex) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }
    Predator predator;
    public Lion(Feline feline){

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

    public boolean doesHaveMane() {

        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return getFood("Хищник");
    }
}
