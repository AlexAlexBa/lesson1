package ru.alex.lesson2.rate_limited_printer;

public class RateLimitedPrinter {
    private int interval;
    private long startInterval;
    public RateLimitedPrinter(int interval) {
        this.interval = interval;
        this.startInterval = System.currentTimeMillis();
    }

    public void print(String message) {
        long nextTimeForPrint = System.currentTimeMillis();
        if (nextTimeForPrint - this.startInterval > interval) {
            this.startInterval = nextTimeForPrint;
            System.out.println(message);
        }
    }
}
