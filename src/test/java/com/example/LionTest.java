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
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void getKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
    }


    @Test
    public void getFood() throws Exception {
        Lion lion = new Lion("Самка", feline);
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(food);

        assertTrue(Objects.equals(lion.getFood(), food));
    }

    //Тест проверяет, что при попытке вызова конструктора с некорректным значением параметра sex выбрасывается эксепшн с заданным текстом
    @Test
    public void doesHaveManeCheckException() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Неопределен", feline));
        assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }

    //Тест проверяет, что doesHaveMane() возвращает ожидаемое boolean значение.
    // Пересекается с параметризованным тестом. Но без него jaCoCo почему-то не считает, что return для doesHaveMane() покрыт тестом. Почему?
    @Test
    public void doesHaveManeReturnValue() throws Exception {
        Lion lion = new Lion("Самец",feline);
        assertTrue(lion.doesHaveMane());
    }
}