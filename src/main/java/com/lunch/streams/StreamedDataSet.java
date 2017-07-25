package com.lunch.streams;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class StreamedDataSet extends DataSetBase {

    @Override
    public Map<String, List<String>> categorizedProducts() {
        return baskets.stream()
                .filter(Basket::isInclude)
                .flatMap(b -> b.getProducts().stream())
                .filter(Product::isInclude)
                .collect(Collectors.groupingBy(Product::getCategory, // the category is the key
                        Collectors.mapping(Product::getName, Collectors.toList()))); // and the value is a list of names
    }


}