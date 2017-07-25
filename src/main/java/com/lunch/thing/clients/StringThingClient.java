package com.lunch.thing.clients;

import com.lunch.thing.Thing;
import com.lunch.thing.ThingAccessor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class StringThingClient {

    /**
     * Uses the accessor to get all the things, and then collects all the names in a single CSV
     * string
     * @return
     */
    public String getAllNamesAsCsv() {
        return ThingAccessor.withAllTheThings("getAllNamesAsCsv", things -> {
            List<String> names = new ArrayList<>();
            for (Thing thing : things) {
                names.add(process(thing, Thing::getName));
            }
            return String.join(",", names);
        });
    }

    /**
     * Uses the accessor to get all the things, and then collects all the names in a single CSV
     * string
     * @return
     */
    public String getAllPositiveNamesAsCsv() {
        return ThingAccessor.withAllTheThings("getAllPositiveNamesAsCsv", things -> {
            List<String> names = new ArrayList<>();
            for (Thing thing : things) {
                if (thing.getNumber() > 0) {
                    names.add(process(thing, Thing::getName));
                }
            }
            return String.join(",", names);
        });
    }

    /**
     * Handles null checks, trimming.
     */
    private String process(Thing thing, Function<Thing, String> tp) {
        return (thing.getName() != null ? tp.apply(thing) : "").trim();
    }

}
