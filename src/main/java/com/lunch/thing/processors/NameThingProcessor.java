package com.lunch.thing.processors;

import com.lunch.thing.Thing;

/**
 * Processes a thing by returning its name
 */
public class NameThingProcessor implements ThingProcessor<String> {

    @Override
    public String processThing(Thing thing) {
        return thing.getName();
    }

}
