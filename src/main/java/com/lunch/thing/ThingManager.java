package com.lunch.thing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Internal class for storing and accessing thing instances.  Outside access to Things is
 * via a ThingAccessor
 */
class ThingManager {

    private static ThingManager instance;
    private final List<Thing> things = new ArrayList<>();

    private ThingManager() {
        for (int i = -5; i <= 5; i++) {
            things.add(new Thing("Thing " + i, i));
        }
    }

    static synchronized final ThingManager Instance() {
        if (ThingManager.instance == null) {
            ThingManager.instance = new ThingManager();
        }
        return ThingManager.instance;
    }

    // All access from outside the package should go through an accessor.
    List<Thing> getThings() {
        return Collections.unmodifiableList(things);
    }

}
