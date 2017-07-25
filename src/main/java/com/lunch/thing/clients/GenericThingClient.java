package com.lunch.thing.clients;

import com.lunch.thing.Thing;
import com.lunch.thing.ThingAccessor;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GenericThingClient<T> {

    /**
     * Allows for any sort of ThingProcessor to be used.
     *
     * @param processor
     * @return
     */
    public List<T> processAllTheThings(Function<Thing, T> processor) {
        return ThingAccessor.withAllTheThings("processAllTheThings",
                things -> things.stream()
                        .filter(t -> t != null)
                        .map(processor)
                        .collect(Collectors.toList()));
    }

}
