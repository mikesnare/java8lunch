package com.lunch.thing.clients;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberThingClientTest {

    @Test
    public void testSumAllThingNumbers() {
        NumberThingClient client = new NumberThingClient();
        assertEquals("Incorrect Sum",
                1 + 4 + 9 + 16 + 25,
                (long) client.sumAllThingNumbersSquared());
    }

}