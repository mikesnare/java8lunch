package com.lunch.thing.clients;

import com.lunch.thing.Thing;
import com.lunch.thing.ThingAccessor;

import java.util.stream.Collectors;

public class StringThingClient {

    /**
     * Uses the accessor to get all the things, and then collects all the names in a single CSV
     * string
     *
     * @return
     */
    public String getAllNamesAsCsv() {
        return ThingAccessor.withAllTheThings("getAllNamesAsCsv",
                things -> things.stream()
                        .filter(t -> t != null)
                        .filter(t -> t.getName() != null)
                        .map(Thing::getName)
                        .map(String::trim)
                        .collect(Collectors.joining(",")));
    }

    /**
     * Uses the accessor to get all the things, and then collects all the names in a single CSV
     * string
     *
     * @return
     */
    public String getAllPositiveNamesAsCsv() {
        return ThingAccessor.withAllTheThings("getAllPositiveNamesAsCsv",
                things -> things.stream()
                        .filter(t -> t != null)
                        .filter(t -> t.getName() != null)
                        .filter(t -> t.getNumber() > 0)
                        .map(Thing::getName)
                        .map(String::trim)
                        .collect(Collectors.joining(",")));
    }

}
