package ru.alex.task2_pell;

import java.util.Scanner;

public class Pell {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            if (n <= 2) {
                System.out.println(n);
            } else {
                int result = 0;
                for (int i = 2, j = 2, k = 1; i < n; i++) {
                    result = j * 2 + k;
                    k = j;
                    j = result;
                }
                System.out.println(result);
            }
        }
    }
}
