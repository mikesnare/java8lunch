package com.lunch.thing.clients;/*
 * This Java source file was generated by the Gradle 'init' task.
 */

import com.lunch.thing.processors.NameThingProcessor;
import com.lunch.thing.processors.NumberThingProcessor;
import com.lunch.thing.processors.ThingProcessor;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ThingClientTest {

    @Test
    public void testProcessAllTheNumbers() {
        GenericThingClient client = new GenericThingClient();
        ThingProcessor processor = new NumberThingProcessor();
        assertEquals("Process All The Numbers failed",
                Arrays.asList(1,2,3,4,5),
                client.processAllTheThings(new NumberThingProcessor()));
    }

    @Test
    public void testProcessAllTheNames() {
        GenericThingClient client = new GenericThingClient();
        ThingProcessor processor = new NumberThingProcessor();
        assertEquals("Process All The Numbers failed",
                Arrays.asList("Thing 1","Thing 2","Thing 3","Thing 4","Thing 5"),
                client.processAllTheThings(new NameThingProcessor()));
    }

}
