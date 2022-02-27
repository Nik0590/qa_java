package com.example;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.runner.RunWith;
//класс
@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Rule

    public ExpectedException exeptionRule = ExpectedException.none();

    @Test
    public void shouldGetKittens() throws Exception {
        int kittensCount = 1;
        Lion lion = new Lion("Самец", feline);
        int actual = lion.getKittens(kittensCount);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetFood() throws Exception{
        Lion lion = new Lion("Самка", feline);
        Mockito.when(lion.getFood()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = lion.getFood();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, actual);
    }

    @Test
    public void doesNotHaveMane() throws Exception {
        exeptionRule.expect(Exception.class);
        exeptionRule.expectMessage("Используйте допустимые значения пола животного - самец или самка");
        Lion lion = new Lion("sdf", feline);
        boolean expected = true;
        boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual);
    }
}