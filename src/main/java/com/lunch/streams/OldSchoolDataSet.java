package com.lunch.streams;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class OldSchoolDataSet extends DataSetBase {

    /**
     * Returns a map of string categories to all Containees that
     * match that category, but only if both the Basket and
     * Product are to be included.
     *
     * @return
     */
    @Override
    public Map<String, List<String>> categorizedProducts() {
        Map<String, List<String>> mapped = new HashMap<>();
        for (Basket container : baskets) {
            if (container.isInclude()) {
                for (Product product : container.getProducts()) {
                    if (product.isInclude()) {
                        List containees = mapped.get(product.getCategory());
                        if (containees == null) {
                            containees = new ArrayList<>();
                            mapped.put(product.getCategory(), containees);
                        }
                        containees.add(product.getName());
                    }
                }
            }
        }
        return mapped;
    }


}