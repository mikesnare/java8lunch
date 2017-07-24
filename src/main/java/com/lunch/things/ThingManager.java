package com.lunch.things;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ThingManager {

    private final List<Thing> things = new ArrayList<>();

    private static ThingManager instance;

    public static synchronized final ThingManager Instance() {
        if (ThingManager.instance == null) {
            ThingManager.instance = new ThingManager(5);
        }
        return ThingManager.instance;
    }

    private ThingManager(int count) {
        for (int i = 1; i <= count; i++) {
            things.add(new Thing("com.lunch.things.Thing " + i, i));
        }
    }

    // All access from outside the package should go through an accessor.
    List<Thing> getThings() {
        return Collections.unmodifiableList(things);
    }

}
