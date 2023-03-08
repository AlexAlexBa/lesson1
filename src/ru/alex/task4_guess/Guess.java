package ru.alex.task4_guess;

import java.util.Random;
import java.util.Scanner;

public class Guess {
    public static void main(String[] args) {
        int number = new Random().nextInt(100);
        int maxAttempts = 10;
        System.out.println("Я загадал число от 1 до 99. У тебя " + maxAttempts + " попыток угадать.");

        try (Scanner scanner = new Scanner(System.in)) {

            for (int i = 0; i < 10; i++) {
                maxAttempts--;
                int n = scanner.nextInt();
                if (n == number) {
                    System.out.println("Ты угадал с " + (10 - maxAttempts++) + " попытки");
                    break;
                } else if (n < number) {
                    System.out.println("Мое число больше. Осталось " + maxAttempts + " попыток");
                } else {
                    System.out.println("Мое число меньше. Осталось " + maxAttempts + " попыток");
                }
            }
        }

        if (maxAttempts == 0) {
            System.out.println("Ты не угадал.");
        }
    }
}

