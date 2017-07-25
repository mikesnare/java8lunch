package com.lunch.thing;

import java.util.List;
import java.util.function.Function;
import java.util.logging.Logger;

/**
 * All access to things must be made through this.  There's a very specific pattern as to how you
 * go about using this.  PMD will complain if you do it wrong...
 */
public class ThingAccessor {

    private static final Logger logger = Logger.getLogger(ThingAccessor.class.getName());

    private final String scope;

    private ThingAccessor(String scope) {
        this.scope = scope;
    }

    public static final ThingAccessor createAccessor(String scope) {
        logger.info("Creating ThingAccessor for scope " + scope);
        return new ThingAccessor(scope);
    }

    /**
     *
     * @param scope For debugging
     * @param handler Will be passed a list of all the things.  Must return a single value
     * @param <R> The return type.
     * @return
     */
    public static final <R> R withAllTheThings(String scope, Function<List<Thing>, R> handler) {

        ThingAccessor accessor = null;
        R result = null;
        try {
            accessor = ThingAccessor.createAccessor(scope);
            accessor.open();
            result = handler.apply(accessor.accessThings().getThings());
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
        }
        return result;
    }

    private void open() throws Exception {
        logger.info("Opening ThingAccessor for scope " + scope);
    }

    private ThingResults accessThings() throws Exception {
        logger.info("Accessing Things for scope " + scope);
        return new ThingResults(ThingManager.Instance().getThings());
    }

    private void close() throws Exception {
        logger.info("Closing ThingAccessor for scope " + scope);
    }

}
