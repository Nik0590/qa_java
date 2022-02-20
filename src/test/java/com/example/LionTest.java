package com.example;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.util.List;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class) // добавили раннер Parameterized
public class LionTest {

    // поля класса:
    private final String checkedSex; // текст, который передаётся в метод
    private final Boolean expected; // ожидаемый результат

    // конструктор с параметрами
    public LionTest(String checkedSex, Boolean expected) {
        this.checkedSex= checkedSex;
        this.expected = expected;
    }

    // метод для получения данных
    @Parameterized.Parameters
    public static Object[][] getSexData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Rule

    public ExpectedException exeptionRule = ExpectedException.none();

    @Test
    public void shouldDoesHaveMane() throws Exception{
        Lion lion = new Lion(checkedSex);
        boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetKittens() throws Exception {
        Lion lion = new Lion("Самка");
        int actual = lion.getKittens();
        int expected = 1;
        assertEquals(expected, actual);
    }


    /*@Test
    public void doesHaveMane() throws Exception {
        Lion lion = new Lion("Самец");
        boolean expected = true;
        boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual);
    }*/



    @Test
    public void shouldGetFood() throws Exception{
        Lion lion = new Lion("Самец");
        List<String> actual = lion.getFood();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
         assertEquals(expected, actual);
    }

    @Test
    public void doesNotHaveMane() throws Exception {
        exeptionRule.expect(Exception.class);
        exeptionRule.expectMessage("Используйте допустимые значения пола животного - самец или самка");
        Lion lion = new Lion("sdf");
        boolean expected = true;
        boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual);
    }
}