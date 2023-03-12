package ru.alex.lesson2.sequences;

import java.util.Scanner;

public class SequencesTest {
    public static void main(String[] args) {
        System.out.println("Введите число, которое будет кол-вом последовательности.");
        Scanner scanner = new Scanner(System.in);
        int amountNumbers = scanner.nextInt();
        scanner.close();

        Sequences sequences = new SequencesImpl();

        sequences.a(amountNumbers);
        System.out.println();

        sequences.b(amountNumbers);
        System.out.println();

        sequences.c(amountNumbers);
        System.out.println();

        sequences.d(amountNumbers);
        System.out.println();

        sequences.e(amountNumbers);
        System.out.println();

        sequences.f(amountNumbers);
        System.out.println();

        sequences.g(amountNumbers);
        System.out.println();

        sequences.h(amountNumbers);
        System.out.println();

        sequences.i(amountNumbers);
        System.out.println();

        sequences.j(amountNumbers);
    }
}
