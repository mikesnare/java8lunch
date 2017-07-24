package com.lunch.thing.clients;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringThingClientTest {

    @Test
    public void testGetAllNamesAsCsv() {
        StringThingClient client = new StringThingClient();
        assertEquals("Incorrect CSV",
                "Thing 1,Thing 2,Thing 3,Thing 4,Thing 5",
                client.getAllNamesAsCsv());
    }

}