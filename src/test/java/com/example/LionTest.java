package com.example;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.util.List;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)

    public class LionTest {

        @Mock
        Feline feline;

        @Rule
        public ExpectedException exeptionRule = ExpectedException.none();
        @Test
        public void shouldGetKittens() throws Exception {
            Lion lion = new Lion("Самка");
            int actual = lion.getKittens(1);
            int expected = 1;
            assertEquals(expected, actual);
        }

        @Test
        public void shouldGetFood() throws Exception {
            Lion lion = new Lion(feline);
            Mockito.when(lion.getFood()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            List<String> actual = lion.getFood();
            List<String> expected = List.of("Животные", "Птицы", "Рыба");
            assertEquals(expected, actual);
        }

        @Test
        public void checkExceptionMessage() throws Exception {
            exeptionRule.expect(Exception.class);
            exeptionRule.expectMessage("Используйте допустимые значения пола животного - самец или самка");
            Lion lion = new Lion("sdf");
            boolean expected = true;
            boolean actual = lion.doesHaveMane();
            assertEquals(expected, actual);
        }

}