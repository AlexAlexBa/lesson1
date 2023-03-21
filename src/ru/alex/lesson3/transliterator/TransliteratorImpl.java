package ru.alex.lesson3.transliterator;

import java.util.HashMap;
import java.util.Map;

public class TransliteratorImpl implements Transliterator {

    private Map<Character, String> sourceMap;

    public TransliteratorImpl(char[] sourceLetters, String[] targetLetters) {
        sourceMap = new HashMap<>();
        for (int i = 0; i < sourceLetters.length; i++) {
            sourceMap.put(sourceLetters[i], targetLetters[i]);
        }
    }

    @Override
    public String transliterate(String source) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            Character letter = source.charAt(i);
            result.append(sourceMap.containsKey(letter) ? sourceMap.get(letter) : letter);
        }
        return result.toString();
    }
}
