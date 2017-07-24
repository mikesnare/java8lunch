package com.lunch.client;

import com.lunch.things.processors.NameThingProcessor;
import com.lunch.things.processors.NumberThingProcessor;
import com.lunch.things.Thing;
import com.lunch.things.ThingAccessor;

import java.util.ArrayList;
import java.util.List;

public class ThingClient {

    public Integer sumAllThingNumbers() {
        ThingAccessor accessor = null;
        Integer result = null;
        try {
            accessor = ThingAccessor.createAccessor("sumAllThingNumbers");
            NumberThingProcessor ntp = new NumberThingProcessor();
            accessor.open();
            int sum = 0;
            for (Thing thing : accessor.accessThings().getThings()) {
                sum += ntp.processThing(thing).intValue();
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

    public String getAllNamesAsCsv() {
        ThingAccessor accessor = null;
        String result = null;
        try {
            accessor = ThingAccessor.createAccessor("getAllNamesAsCsv");
            NameThingProcessor ntp = new NameThingProcessor();
            List<String> names = new ArrayList<>();
            for (Thing thing : accessor.accessThings().getThings()) {
                names.add(ntp.processThing(thing));
            }
            result = String.join(",", names);
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
