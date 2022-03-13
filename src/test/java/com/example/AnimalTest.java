package com.example;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class AnimalTest {

    @Test

    public void herbivoreGetFood() throws Exception{

        Animal animal = new Animal();
        List<String> actual = animal.getFood("Травоядное");
        List<String> expected = List.of("Трава", "Различные растения");
        assertEquals(expected, actual);
    }

    @Test

    public void unknownAnimalGetFood() throws Exception{
        try {
            Animal animal = new Animal();
            animal.getFood("Комарик");
            Assert.fail("Expected IOException");
        } catch (Exception ex) {
            Assert.assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", ex.getMessage());
            Assert.assertNotEquals("", ex.getMessage());
        }
    }

    @Test

    public void animalGetFamily(){

        Animal animal = new Animal();
        String actual = animal.getFamily();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, actual);
    }
}