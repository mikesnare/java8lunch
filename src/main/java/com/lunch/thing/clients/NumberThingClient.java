package com.lunch.thing.clients;

import com.lunch.thing.Thing;
import com.lunch.thing.ThingAccessor;

public class NumberThingClient {

    /**
     * Uses the accessor to get all the things, and then sums the numbers across all the things.
     *
     * @return
     */
    public Integer sumAllThingNumbersSquared() {
        return ThingAccessor.withAllTheThings("sumAllThingNumbersSquared",
                things -> things.stream()
                        .filter(t -> t != null)
                        .filter(t -> t.getNumber() != null)
                        .map(Thing::getNumber)
                        .mapToInt(Integer::intValue)
                        .mapToDouble(i -> Math.pow(i, 2))
                        .mapToInt(d -> (int) d)
                        .sum());
    }

    /**
     * Uses the accessor to get all the things, and then sums the numbers across all the things.
     *
     * @return
     */
    public Integer sumAllPositiveThingNumbersSquared() {
        return ThingAccessor.withAllTheThings("sumAllPositiveThingNumbersSquared",
                things -> things.stream()
                        .filter(t -> t != null)
                        .filter(t -> t.getNumber() != null)
                        .filter(t -> t.getNumber() > 0)
                        .map(Thing::getNumber)
                        .mapToInt(Integer::intValue)
                        .mapToDouble(i -> Math.pow(i, 2))
                        .mapToInt(d -> (int) d)
                        .sum());
    }

}
