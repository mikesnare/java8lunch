package com.lunch.thing.processors;

import com.lunch.thing.Thing;

/**
 * Knows how to process an individual thing and return something else.
 * @param <R>
 */
@FunctionalInterface
public interface ThingProcessor<R> {

    R processThing(Thing thing);

}
