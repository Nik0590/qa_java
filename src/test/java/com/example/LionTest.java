package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

//класс
@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;


    @Test
    public void shouldGetFood() throws Exception{
        Lion lion = new Lion("Самка", feline);
        List<String> actual = lion.getFood();
        List<String> expected = feline.getFood("Хищник");
        assertEquals(expected, actual);
    }

    @Test
    public void doesNotHaveMane() throws Exception {
        try {
            Lion lion = new Lion("sdf", feline);
            lion.doesHaveMane();
            Assert.fail("Expected IOException");
        } catch (Exception ex) {
            Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", ex.getMessage());
            Assert.assertNotEquals("", ex.getMessage());
        }
    }
}