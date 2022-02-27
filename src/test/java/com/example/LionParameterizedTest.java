package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

//класс
public class LionParameterizedTest {

    // поля класса:
    private final String checkedSex; // текст, который передаётся в метод
    private final Boolean expected; // ожидаемый результат

    // конструктор с параметрами
    public LionParameterizedTest(String checkedSex, Boolean expected) {
        this.checkedSex = checkedSex;
        this.expected = expected;
    }

    // метод для получения данных
    @Parameterized.Parameters
    public static Object[][] getSexData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void shouldDoesHaveMane() throws Exception {
        Lion lion = new Lion(checkedSex);
        boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual);
    }
}
