package com.lunch.thing.clients;/*
 * This Java source file was generated by the Gradle 'init' task.
 */

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ThingClientTest {

    @Test
    public void testProcessAllTheNumbers() {
        GenericThingClient client = new GenericThingClient();
        assertEquals("Process All The Numbers failed",
                Arrays.asList(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5),
                client.processAllTheThings(t -> t.getNumber()));
    }

    @Test
    public void testProcessAllTheNames() {
        GenericThingClient client = new GenericThingClient();
        assertEquals("Process All The Numbers failed",
                Arrays.asList("Thing -5", "Thing -4", "Thing -3", "Thing -2", "Thing -1", "Thing 0", "Thing 1", "Thing 2", "Thing 3", "Thing 4", "Thing 5"),
                client.processAllTheThings(t -> t.getName()));
    }

}
