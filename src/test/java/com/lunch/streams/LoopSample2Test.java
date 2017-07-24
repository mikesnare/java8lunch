package com.lunch.streams;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class LoopSample2Test {

    private Sample sample;

    @Before
    public void setup() {
        this.sample = new LoopSample2();
    }

    @Test
    public void testGetNullValues() {
        Assert.assertEquals(0, sample.getNullValues().stream().filter(i -> i != null).count());
    }

    @Test
    public void testGetNonNullValues() {
        Assert.assertEquals(0, sample.getNonNullNumbers().stream().filter(i -> i == null).count());
    }

    @Test
    public void testGetAllEvenNumbers() {
        sample.getAllEvenNumbers().stream().forEach(i -> Assert.assertTrue("Got some odds", i % 2 == 0));
    }

    @Test
    public void testGetAllOddNumbers() {
        sample.getAllOddNumbers().stream().forEach(i -> Assert.assertTrue("Got some odds", i % 2 == 1));
    }

    @Test
    public void testGetSquaredValues() throws Exception {
        List<Integer> roots = sample.getNonNullNumbers();
        List<Double> squared = sample.getSquaredValues();
        for (int i = 0; i < roots.size(); i++) {
            Assert.assertEquals(squared.get(i), Math.pow(roots.get(i), 2), 0);
        }
    }

    @Test
    public void testGetAllSum() {
        Assert.assertEquals(sample.getNonNullNumbers().stream().mapToInt(Integer::intValue).sum(), (long)sample.getAllSum());
    }

    @Test
    public void testGetEvenSum() {
        Assert.assertEquals(sample.getAllEvenNumbers().stream().mapToInt(Integer::intValue).sum(), (long)sample.getEvenSum());
    }

    @Test
    public void testGetOddSum() {
        Assert.assertEquals(sample.getAllOddNumbers().stream().mapToInt(Integer::intValue).sum(), (long)sample.getOddSum());
    }

    @Test
    public void testGetAllAverage() {
        List<Integer> numbers = sample.getNonNullNumbers();
        Assert.assertEquals(numbers.stream().mapToInt(Integer::intValue).sum() / (double) numbers.size(), sample.getAverage(), 1);
    }

    @Test
    public void testGetEvenAverage() {
        List<Integer> numbers = sample.getAllEvenNumbers();
        Assert.assertEquals(numbers.stream().mapToInt(Integer::intValue).sum() / (double) numbers.size(), sample.getEvenAverage(), 1);
    }

    @Test
    public void testGetOddAverage() {
        List<Integer> numbers = sample.getAllOddNumbers();
        Assert.assertEquals(numbers.stream().mapToInt(Integer::intValue).sum() / (double) numbers.size(), sample.getOddAverage(), 1);
    }

}
