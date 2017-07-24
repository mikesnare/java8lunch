package com.lunch.thing.processors;

import com.lunch.thing.Thing;

/**
 * Processes a thing by returning its number
 */
public class NumberThingProcessor implements ThingProcessor<Integer> {

    @Override
    public Integer processThing(Thing thing) {
        return thing.getNumber();
    }

}
