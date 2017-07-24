package com.lunch.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Sample {

    protected List<Integer> numbers = new ArrayList<>();

    public Sample() {
        Random random = new Random();
        for (int i = -10_000; i <= 10_000; i++) {
            // 5% chance of a null
            if (random.nextInt(100) < 5) {
                numbers.add(null);
            } else {
                numbers.add(i);
            }
        }
    }

    public abstract List<Integer> getNullValues();

    public abstract List<Integer> getNonNullNumbers();

    public abstract List<Integer> getAllEvenNumbers();

    public abstract List<Integer> getAllOddNumbers();

    public abstract List<Double> getSquaredValues();

    public abstract Integer getAllSum();

    public abstract Integer getEvenSum();

    public abstract Integer getOddSum();

    // average functions ignore nulls
    public abstract Double getAverage();

    public abstract Double getEvenAverage();

    public abstract Double getOddAverage();

}
