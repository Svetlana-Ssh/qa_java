package com.example;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;

public class FelineTest {

    @Test
    public void eatMeat() throws Exception {
        Feline feline = new Feline();
        // food - содержит список значений, который должен вернуться методом eatMeat()
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        assertTrue(Objects.equals(feline.eatMeat(), food));
    }

    @Test
    public void getFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittens() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensCount() {
        Feline feline = new Feline();
        assertEquals(2, feline.getKittens(2));
    }
}