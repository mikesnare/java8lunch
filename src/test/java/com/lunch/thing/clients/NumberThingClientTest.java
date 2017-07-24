package com.lunch.thing.clients;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberThingClientTest {

    @Test
    public void testSumAllThingNumbers() {
        NumberThingClient client = new NumberThingClient();
        assertEquals("Incorrect Sum",
                2*1 + 2*4 + 2*9 + 2*16 + 2*25,
                (long) client.sumAllThingNumbersSquared());
    }

    @Test
    public void testSumAllPositiveThingNumbers() {
        NumberThingClient client = new NumberThingClient();
        assertEquals("Incorrect Sum",
                1 + 4 + 9 + 16 + 25,
                (long) client.sumAllPositiveThingNumbersSquared());
    }

}