package com.lunch.thing.clients;

import com.lunch.thing.Thing;
import com.lunch.thing.ThingAccessor;
import com.lunch.thing.processors.NumberThingProcessor;

public class NumberThingClient {

    /**
     * Uses the accessor to get all the things, and then sums the numbers across all the things.
     * @return
     */
    public Integer sumAllThingNumbersSquared() {
        ThingAccessor accessor = null;
        Integer result = null;
        try {
            accessor = ThingAccessor.createAccessor("sumAllThingNumbers");
            NumberThingProcessor ntp = new NumberThingProcessor();
            accessor.open();
            int sum = 0;
            for (Thing thing : accessor.accessThings().getThings()) {
                sum += Math.pow(ntp.processThing(thing).intValue(), 2);
            }
            result = Integer.valueOf(sum);
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
            return result;
        }
    }

    /**
     * Uses the accessor to get all the things, and then sums the numbers across all the things.
     * @return
     */
    public Integer sumAllPositiveThingNumbersSquared() {
        ThingAccessor accessor = null;
        Integer result = null;
        try {
            accessor = ThingAccessor.createAccessor("sumAllThingNumbers");
            NumberThingProcessor ntp = new NumberThingProcessor();
            accessor.open();
            int sum = 0;
            for (Thing thing : accessor.accessThings().getThings()) {
                if (thing.getNumber() > 0) {
                    sum += Math.pow(ntp.processThing(thing).intValue(), 2);
                }
            }
            result = Integer.valueOf(sum);
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
            return result;
        }
    }

}
