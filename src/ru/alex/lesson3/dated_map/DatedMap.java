package ru.alex.lesson3.dated_map;

import java.text.ParseException;
import java.util.Date;
import java.util.Set;

public interface DatedMap {
    void put(String key, String value);
    String get(String key);
    boolean containsKey(String key);
    void remove(String key);
    Set<String> keySet();
    Date getKeyLastInsertionDate(String key) throws ParseException;
}
