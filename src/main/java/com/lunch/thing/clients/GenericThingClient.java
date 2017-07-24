package com.lunch.thing.clients;

import com.lunch.thing.Thing;
import com.lunch.thing.ThingAccessor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class GenericThingClient<T> {

    /**
     * Allows for any sort of ThingProcessor to be used.
     * @param processor
     * @return
     */
    public List<T> processAllTheThings(Function<Thing, T> processor) {
        return ThingAccessor.withAllTheThings("processAllTheThings", things -> {
            List<T> results = new ArrayList<>();
            for (Thing thing : things) {
                results.add(processor.apply(thing));
            }
            return results;
        });
    }

}
