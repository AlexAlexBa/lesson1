package ru.alex.lesson2.stats_accumulator;

public class StatsAccumulatorImpl implements StatsAccumulator {
    private int max;
    private int min;
    private int count;
    private int sum;

    @Override
    public void add(int value) {
        this.sum += value;
        if (min > value) {
            min = value;
        } else if (max < value) {
            max = value;
        }
        count++;
    }

    @Override
    public int getMin() {
        return min;
    }

    @Override
    public int getMax() {
        return max;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Double getAvg() {
        return (double) sum / count;
    }
}
