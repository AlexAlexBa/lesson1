package ru.alex.lesson3.dated_map;

import java.text.ParseException;

public class DatedMapTest {
    public static void main(String[] args) throws ParseException, InterruptedException {
        DatedMapImpl datedMap = new DatedMapImpl();

        datedMap.put("1", "one");
        Thread.sleep(2000);

        datedMap.put("2", "two");
        System.out.println("Проверка добавления: количество " + datedMap.keySet().size());
        System.out.println();

        System.out.println("Получение значения по существующему ключу: " + datedMap.get("1"));
        System.out.println("Получение значения по несуществующему ключу: " + datedMap.get("One"));
        System.out.println();

        System.out.println("Проверка добавления времени пары: " + datedMap.getKeyLastInsertionDate("1"));
        System.out.println("Проверка добавления времени пары через 2 секунды: " + datedMap.getKeyLastInsertionDate("2"));
        System.out.println("Проверка времени несуществующего ключа: " + datedMap.getKeyLastInsertionDate("Two"));
        System.out.println();

        System.out.println("Проверка значения по существующему ключу: " + datedMap.containsKey("1"));
        System.out.println("Проверка значения по несуществующему ключу: " + datedMap.containsKey("One"));
        System.out.println();

        datedMap.remove("1");
        System.out.println("Проверка удаления пары: количество " + datedMap.keySet().size());
    }
}
