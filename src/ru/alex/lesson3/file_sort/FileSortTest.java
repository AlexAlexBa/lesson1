package ru.alex.lesson3.file_sort;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

public class FileSortTest {
    public static void main(String[] args) throws IOException {
        System.out.println("start: " + LocalTime.now());

        File dataFile = new Generator().generate("src/resources/numbers.txt", 375_000_000);
        System.out.println(new Validator(dataFile).isSorted()); // false
        File sortedFile = new Sorter().sortFile(dataFile);
        System.out.println(new Validator(sortedFile).isSorted()); // true

        System.out.println("finish: " + LocalTime.now());
    }
}
