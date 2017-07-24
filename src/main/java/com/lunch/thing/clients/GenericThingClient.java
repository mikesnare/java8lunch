package com.lunch.thing.clients;

import com.lunch.thing.Thing;
import com.lunch.thing.ThingAccessor;
import com.lunch.thing.processors.ThingProcessor;

import java.util.ArrayList;
import java.util.List;

public class GenericThingClient<T> {

    /**
     * Allows for any sort of ThingProcessor to be used.
     * @param processor
     * @return
     */
    public List<T> processAllTheThings(ThingProcessor<T> processor) {
        ThingAccessor accessor = null;
        List<T> results = new ArrayList<>();
        try {
            accessor = ThingAccessor.createAccessor("processAllTheThings");
            for (Thing thing : accessor.accessThings().getThings()) {
                results.add(processor.processThing(thing));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (accessor != null) {
                try {
                    accessor.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return results;
        }
    }

}
