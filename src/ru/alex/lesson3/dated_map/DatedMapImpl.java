package ru.alex.lesson3.dated_map;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DatedMapImpl implements DatedMap {

    private Map<String, List<String>> map = new HashMap<>();

    @Override
    public void put(String key, String value) {
        map.put(key, new ArrayList<>(List.of(value, new Date().toString())));
    }

    @Override
    public String get(String key) {
        return map.containsKey(key) ? map.get(key).get(0) : null;
    }

    @Override
    public boolean containsKey(String key) {
        return map.containsKey(key);
    }

    @Override
    public void remove(String key) {
        map.remove(key);
    }

    @Override
    public Set<String> keySet() {
        return map.keySet();
    }

    @Override
    public Date getKeyLastInsertionDate(String key) throws ParseException {
        return map.containsKey(key) ? new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy",
                Locale.ENGLISH).parse(map.get(key).get(1)) : null;
    }
}
