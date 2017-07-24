package com.lunch.thing;

import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * Simple wrapper around some number of things.  These are returned by the ThingAccessor
 */
@Data
public class ThingResults {

    private final List<Thing> things;

    public ThingResults(List<Thing> things) {
        this.things = Collections.unmodifiableList(things);
    }

}
