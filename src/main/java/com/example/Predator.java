package com.example;

import java.util.List;
//интерфейс
public interface Predator {

    List<String> eatMeat() throws Exception;

    int getKittens();

    int getKittens(int kittensCount);
}
