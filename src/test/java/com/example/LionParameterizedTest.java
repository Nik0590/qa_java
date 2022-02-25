package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class LionParameterizedTest {

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

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Mock
    Feline feline;

    @Test
    public void shouldDoesHaveMane() throws Exception {
        Lion lion = new Lion(checkedSex, feline);
        boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual);
    }
}
