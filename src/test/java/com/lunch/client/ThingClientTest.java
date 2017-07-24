package com.lunch.client;/*
 * This Java source file was generated by the Gradle 'init' task.
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThingClientTest {

    @Test
    public void testSumAllThingNumbers() {
        ThingClient client = new ThingClient();
        assertEquals("Incorrect Sum",
                1 + 2 + 3 + 4 + 5,
                (long) client.sumAllThingNumbers());
    }

    @Test
    public void testGetAllNamesAsCsv() {
        ThingClient client = new ThingClient();
        assertEquals("Incorrect CSV",
                "com.lunch.things.Thing 1,com.lunch.things.Thing 2,com.lunch.things.Thing 3,com.lunch.things.Thing 4,com.lunch.things.Thing 5",
                client.getAllNamesAsCsv());
    }

}
