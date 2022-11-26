package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void getSound() {
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }

    //Тест проверяет, что при вызове getFood() внутри один раз происходит вызов feline.eatMeat()
    @Test
    public void getFood() throws Exception {
        Cat cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }

    //Тест проверяет, что getFood() возвращает определенные значения
    @Test
    public void getFoodReturnsValues() throws Exception {
        Cat cat = new Cat(feline);

        List<String> food = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(food);
        System.out.println(cat.getFood());
        assertTrue(Objects.equals(food, cat.getFood()));
    }

}