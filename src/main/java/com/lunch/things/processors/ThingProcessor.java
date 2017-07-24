package com.lunch.things.processors;

import com.lunch.things.Thing;

/**
 * Knows how to process an individual thing and return something else.
 * @param <R>
 */
public interface ThingProcessor<R> {

    public R processThing(Thing thing);

}
