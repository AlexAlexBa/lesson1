package ru.alex.lesson2.stats_accumulator;

public class StatsAccumulatorTest {
    public static void main(String[] args) {
        StatsAccumulator statsAccumulator = new StatsAccumulatorImpl();
        statsAccumulator.add(1);
        statsAccumulator.add(2);
        System.out.println("Среднее арифметическое " + statsAccumulator.getAvg());
        statsAccumulator.add(0);
        System.out.println("Минимальное " + statsAccumulator.getMin());
        statsAccumulator.add(3);
        statsAccumulator.add(8);
        System.out.println("Максимальное " + statsAccumulator.getMax());
        System.out.println("Количество чисел " + statsAccumulator.getCount());
    }
}
