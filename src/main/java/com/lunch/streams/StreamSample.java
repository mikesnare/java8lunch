package com.lunch.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamSample extends Sample {

    private Stream<Integer> nonNullStream() {
        return numbers.stream()
                .filter(i -> i != null);
    }

    private Stream<Integer> evenStream() {
        return nonNullStream()
                .filter(i -> i % 2 == 0);
    }

    private Stream<Integer> oddStream() {
        return nonNullStream()
                .filter(i -> i % 2 == 1);
    }

    private IntStream intStream(Stream<Integer> stream) {
        return stream
                .mapToInt(Integer::intValue);
    }

    private Integer _sum(Stream<Integer> stream) {
        return intStream(stream)
                .sum();
    }

    private Double _avg(Stream<Integer> stream) {
        return intStream(stream)
                .average()
                .getAsDouble();
    }

    @Override
    public List<Integer> getNullValues() {
        return numbers.stream()
                .filter(i -> i == null)
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> getNonNullNumbers() {
        return nonNullStream()
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> getAllEvenNumbers() {
        return evenStream()
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> getAllOddNumbers() {
        return oddStream()
                .collect(Collectors.toList());
    }

    @Override
    public List<Double> getSquaredValues() {
        return nonNullStream()
                .map(i -> Math.pow(i, 2))
                .collect(Collectors.toList());
    }

    @Override
    public Integer getAllSum() {
        return _sum(nonNullStream());
    }

    @Override
    public Integer getEvenSum() {
        return _sum(evenStream());
    }

    @Override
    public Integer getOddSum() {
        return _sum(oddStream());
    }

    @Override
    public Double getAverage() {
        return _avg(nonNullStream());
    }

    @Override
    public Double getEvenAverage() {
        return _avg(evenStream());
    }

    @Override
    public Double getOddAverage() {
        return _avg(oddStream());
    }

}
