package com.lunch.things;

import java.util.List;
import java.util.logging.Logger;

/**
 * All access to things must be made through this
 */
public class ThingAccessor {

    private static final Logger logger = Logger.getLogger(ThingAccessor.class.getName());

    private final String scope;

    private ThingAccessor(String scope) {
        this.scope = scope;
    }

    public static final ThingAccessor createAccessor(String scope) {
        return new ThingAccessor(scope);
    }

    public void open() throws Exception {
        logger.info("Opening ThingAccessor for scope " + scope);
    }

    public ThingResults accessThings() throws Exception {
        logger.info("Accessing Things for scope " + scope);
        return new ThingResults(ThingManager.Instance().getThings());
    }

    public void close() throws Exception {
        logger.info("Closing ThingAccessor for scope " + scope);
    }

}
