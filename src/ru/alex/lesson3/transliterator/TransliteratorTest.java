package ru.alex.lesson3.transliterator;

public class TransliteratorTest {
    public static void main(String[] args) {

        char[] russianLetters = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О',
                'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ы', 'Ь', 'Ъ', 'Э', 'Ю', 'Я'};
        String [] englishLetters = {"A", "B", "V", "G", "D", "E", "E", "ZH", "Z", "I", "I", "K", "L", "M", "N", "O",
                "P", "R", "S", "T", "U", "F", "KH", "TS", "CH", "SH", "SHCH", "Y", "", "IE", "E", "IU", "IA"};

        Transliterator transliterator = new TransliteratorImpl(russianLetters, englishLetters);

        String res = transliterator.transliterate("HELLO! ПРИВЕТ! Go, boy!");
        System.out.println(res);

        String allRussianLetters = transliterator
                .transliterate("Ylab! ЮЖНО-ЭФИОПСКИЙ ГРАЧ УВЁЛ МЫШЬ ЗА ХОБОТ НА СЪЕЗД ВСЕХ ЯЩЕРИЦ!");
        System.out.println(allRussianLetters);

    }
}
