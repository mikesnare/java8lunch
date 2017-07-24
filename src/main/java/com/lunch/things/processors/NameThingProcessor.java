package com.lunch.things.processors;

import com.lunch.things.Thing;

/**
 * Processes a thing by returning its name
 */
public class NameThingProcessor implements ThingProcessor<String> {

    @Override
    public String processThing(Thing thing) {
        return thing.getName();
    }

}
