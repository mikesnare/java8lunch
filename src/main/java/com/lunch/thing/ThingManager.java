package com.lunch.thing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Internal class for storing and accessing thing instances.
 */
class ThingManager {

    private final List<Thing> things = new ArrayList<>();

    private static ThingManager instance;

    static synchronized final ThingManager Instance() {
        if (ThingManager.instance == null) {
            ThingManager.instance = new ThingManager(5);
        }
        return ThingManager.instance;
    }

    private ThingManager(int count) {
        for (int i = 1; i <= count; i++) {
            things.add(new Thing("Thing " + i, i));
        }
    }

    // All access from outside the package should go through an accessor.
    List<Thing> getThings() {
        return Collections.unmodifiableList(things);
    }

}
