package com.example;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.junit.Assert.*;
//класс
public class AnimalTest {

    @Rule

    public ExpectedException exeptionRule = ExpectedException.none();

    @Test

    public void herbivoreGetFood() throws Exception{

        Animal animal = new Animal();
        List<String> actual = animal.getFood("Травоядное");
        List<String> expected = List.of("Трава", "Различные растения");
        assertEquals(expected, actual);
    }

    @Test

    public void unknownAnimalGetFood() throws Exception{
        exeptionRule.expect(Exception.class);
        exeptionRule.expectMessage("Неизвестный вид животного, используйте значение Травоядное или Хищник");
        Animal animal = new Animal();
        boolean expected = true;
        boolean actual = Boolean.parseBoolean(String.valueOf(animal.getFood("Комарик")));
        assertEquals(expected, actual);
    }

    @Test

    public void animalGetFamily(){

        Animal animal = new Animal();
        String actual = animal.getFamily();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, actual);
    }

}