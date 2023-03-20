package ru.alex.lesson2.rate_limited_printer;

public class RateLimitedPrinterTest {
    public static void main(String[] args) {
        RateLimitedPrinter rateLimitedPrinter = new RateLimitedPrinter(3000);
        for ( ; ; ) {
            rateLimitedPrinter.print("Hello YLAB! Таймер в милисекундах: " + System.currentTimeMillis() );
        }
    }
}
