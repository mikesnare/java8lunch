package com.lunch.thing;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * Simple wrapper around some number of things.  These are returned by the ThingAccessor
 */
@Data
@AllArgsConstructor
public class ThingResults {

    private final List<Thing> things;

}
