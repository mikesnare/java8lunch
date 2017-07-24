package com.lunch.things.processors;

import com.lunch.things.Thing;

/**
 * Processes a thing by returning its number
 */
public class NumberThingProcessor implements ThingProcessor<Integer> {

    @Override
    public Integer processThing(Thing thing) {
        return thing.getNumber();
    }

}
