package ru.alex.task1_stars;

import java.util.Scanner;

public class Stars {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            String template = scanner.next();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print((j == m - 1) ? template : (template + " "));
                }
                System.out.println();
            }
        }
    }
}
