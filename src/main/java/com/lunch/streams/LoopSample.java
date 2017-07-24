package com.lunch.streams;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements Sample with straight-forward code, avoiding the creation of any new interim list instances.
 * <p>
 * Fastest implementation, but leads to duplicate code.
 */
public class LoopSample extends Sample {

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
        for (Integer i : numbers) {
            if (i != null) {
                if (i % 2 == 0) {
                    evens.add(i);
                }
            }
        }
        return evens;
    }

    @Override
    public List<Integer> getAllOddNumbers() {
        List<Integer> odds = new ArrayList<>();
        for (Integer i : numbers) {
            if (i != null) {
                if (i % 2 == 1) {
                    odds.add(i);
                }
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
        for (Integer i : numbers) {
            if (i != null) {
                squares.add(Math.pow(i, 2));
            }
        }
        return squares;
    }

    @Override
    public Integer getAllSum() {
        int sum = 0;
        for (Integer i : numbers) {
            if (i != null) {
                sum += i;
            }
        }
        return sum;
    }

    @Override
    public Integer getEvenSum() {
        int sum = 0;
        for (Integer i : numbers) {
            if (i != null) {
                if (i % 2 == 0) {
                    sum += i;
                }
            }
        }
        return sum;
    }

    @Override
    public Integer getOddSum() {
        int sum = 0;
        for (Integer i : numbers) {
            if (i != null) {
                if (i % 2 == 1) {
                    sum += i;
                }
            }
        }
        return sum;
    }

    @Override
    public Double getAverage() {
        int sum = 0;
        for (Integer i : numbers) {
            if (i != null) {
                sum += i;
            }
        }
        return sum / (double) numbers.size();
    }

    @Override
    public Double getEvenAverage() {
        int sum = 0;
        double count = 0;
        for (Integer i : numbers) {
            if (i != null) {
                if (i % 2 == 0) {
                    sum += i;
                    count++;
                }
            }
        }
        return sum / count;
    }

    @Override
    public Double getOddAverage() {
        int sum = 0;
        double count = 0;
        for (Integer i : numbers) {
            if (i != null) {
                if (i % 2 == 1) {
                    sum += i;
                    count++;
                }
            }
        }
        return sum / count;
    }

}
