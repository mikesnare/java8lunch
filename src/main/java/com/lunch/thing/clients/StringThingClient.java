package com.lunch.thing.clients;

import com.lunch.thing.Thing;
import com.lunch.thing.ThingAccessor;
import com.lunch.thing.processors.NameThingProcessor;

import java.util.ArrayList;
import java.util.List;

public class StringThingClient {

    /**
     * Uses the accessor to get all the things, and then collects all the names in a single CSV
     * string
     * @return
     */
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

    /**
     * Uses the accessor to get all the things, and then collects all the names in a single CSV
     * string
     * @return
     */
    public String getAllPositiveNamesAsCsv() {
        ThingAccessor accessor = null;
        String result = null;
        try {
            accessor = ThingAccessor.createAccessor("getAllNamesAsCsv");
            NameThingProcessor ntp = new NameThingProcessor();
            List<String> names = new ArrayList<>();
            for (Thing thing : accessor.accessThings().getThings()) {
                if (thing.getNumber() > 0) {
                    names.add(ntp.processThing(thing));
                }
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
