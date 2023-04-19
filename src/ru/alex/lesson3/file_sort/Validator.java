package ru.alex.lesson3.file_sort;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Validator {
    private File file;
    private int size;
    
    public Validator(File file, int size) {
        this.file = file;
        this.size = size;
    }
    public boolean isSorted() {
        try (Scanner scanner = new Scanner(new FileInputStream(file))) {
            long prev = Long.MIN_VALUE;
            int counter = 0;
            while (scanner.hasNextLong()) {
                long current = scanner.nextLong();
                if (current < prev) {
                    return false;
                } else {
                    prev = current;
                }
                counter++;
            }
            return size == counter;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
