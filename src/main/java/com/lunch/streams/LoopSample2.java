package com.lunch.streams;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements Sample using loops with as much code re-use as I can muster.  Requires that each method
 * return a new instance of a list.
 */
public class LoopSample2 extends Sample {

    private int _sum(List<Integer> ints) {
        int sum = 0;
        for (Integer i : ints) {
            sum += i;
        }
        return sum;
    }

    private Double _avg(List<Integer> ints) {
        return _sum(ints) / (double) ints.size();
    }

    @Override
    public List<Integer> getNonNullNumbers() {
        List<Integer> nonNulls = new ArrayList<>();
        for (Integer i : numbers) {
            if (i != null) {
                nonNulls.add(i);
            }
        }
        return nonNulls;
    }

    @Override
    public List<Integer> getAllEvenNumbers() {
        List<Integer> evens = new ArrayList<>();
        for (Integer i : getNonNullNumbers()) {
            if (i % 2 == 0) {
                evens.add(i);
            }
        }
        return evens;
    }

    @Override
    public List<Integer> getAllOddNumbers() {
        List<Integer> odds = new ArrayList<>();
        for (Integer i : getNonNullNumbers()) {
            if (i % 2 == 1) {
                odds.add(i);
            }
        }
        return odds;
    }

    @Override
    public List<Integer> getNullValues() {
        List<Integer> nulls = new ArrayList<>();
        for (Integer i : numbers) {
            if (i == null) {
                nulls.add(i);
            }
        }
        return nulls;
    }

    @Override
    public List<Double> getSquaredValues() {
        List<Double> squares = new ArrayList<>();
        for (Integer i : getNonNullNumbers()) {
            squares.add(Math.pow(i, 2));
        }
        return squares;
    }

    @Override
    public Integer getAllSum() {
        return _sum(getNonNullNumbers());
    }

    @Override
    public Integer getEvenSum() {
        return _sum(getAllEvenNumbers());
    }

    @Override
    public Integer getOddSum() {
        return _sum(getAllOddNumbers());
    }

    @Override
    public Double getAverage() {
        return _avg(getNonNullNumbers());
    }

    @Override
    public Double getEvenAverage() {
        return _avg(getAllEvenNumbers());
    }

    @Override
    public Double getOddAverage() {
        return _avg(getAllOddNumbers());
    }

}
