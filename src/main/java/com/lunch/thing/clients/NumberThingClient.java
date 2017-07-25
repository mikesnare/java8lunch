package com.lunch.thing.clients;

import com.lunch.thing.Thing;
import com.lunch.thing.ThingAccessor;

import java.util.function.Function;

public class NumberThingClient {

    /**
     * Uses the accessor to get all the things, and then sums the numbers across all the things.
     * @return
     */
    public Integer sumAllThingNumbersSquared() {
        return ThingAccessor.withAllTheThings("sumAllThingNumbersSquared", things -> {
            int sum = 0;
            for (Thing thing : things) {
                sum += Math.pow(process(thing, Thing::getNumber), 2);
            }
            return sum;
        });
    }

    /**
     * Uses the accessor to get all the things, and then sums the numbers across all the things.
     * @return
     */
    public Integer sumAllPositiveThingNumbersSquared() {
        return ThingAccessor.withAllTheThings("sumAllPositiveThingNumbersSquared", things -> {
            int sum = 0;
            for (Thing thing : things) {
                if (thing.getNumber() > 0) {
                    sum += Math.pow(process(thing, Thing::getNumber), 2);
                }
            }
            return sum;
        });
    }

    /**
     * Handles null checks, conversion to int.
     */
    private int process(Thing thing, Function<Thing, Integer> tp) {
        return thing.getNumber() != null ? tp.apply(thing).intValue() : 0;
    }

}
