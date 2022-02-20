package com.example;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)


public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void shouldGetSound() {
        Cat cat = new Cat(feline);
        String actual = cat.getSound();
        String expected = "Мяу";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetFood() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = feline.getFood("Хищник");
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, actual);
    }

    @Test
    public void  catGetKittens() {
        Cat cat = new Cat(feline);
        Integer actual = cat.getKittens();
        Integer expected = 1;
        assertEquals(expected, actual);
    }
}