package com.lunch.streams;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public abstract class DataSetTestBase {

    private final DataSetBase dataSet;

    public DataSetTestBase(DataSetBase dataSet) {
        this.dataSet = dataSet;
    }

    @Test
    public void hasNoApples() throws Exception {
        Map<String, List<String>> categorizedProducts = dataSet.categorizedProducts();
        for (List<String> products : categorizedProducts.values()) {
            Assert.assertFalse(products.contains(DataSetBase.APPLE));
        }
    }

    @Test
    public void hasNoBathProducts() {
        Assert.assertFalse(dataSet.categorizedProducts().containsKey(DataSetBase.BATH));
    }

    @Test
    public void hasExpectedCategories() {
        Map<String, List<String>> categorizedProducts = dataSet.categorizedProducts();
        Assert.assertTrue(categorizedProducts.containsKey(DataSetBase.FRUIT));
        Assert.assertTrue(categorizedProducts.containsKey(DataSetBase.KITCHEN));
        Assert.assertTrue(categorizedProducts.containsKey(DataSetBase.VEGETABLES));
        Assert.assertTrue(categorizedProducts.containsKey(DataSetBase.DAIRY));
    }

    @Test
    public void fruitHasExpectedProducts() {
        checkProducts(DataSetBase.FRUIT, DataSetBase.ORANGE, DataSetBase.GRAPES, DataSetBase.WATERMELON, DataSetBase.KIWI);
    }

    @Test
    public void kitchenHasExpectedProducts() {
        checkProducts(DataSetBase.KITCHEN, DataSetBase.DAWN, DataSetBase.SPONGE, DataSetBase.KNIFE);
    }

    @Test
    public void vegetablesHasExpectedProducts() {
        checkProducts(DataSetBase.VEGETABLES, DataSetBase.CELERY, DataSetBase.POTATO);
    }

    @Test
    public void dairyHasExpectedProducts() {
        checkProducts(DataSetBase.DAIRY, DataSetBase.CHEESE, DataSetBase.MILK);
    }


    private void checkProducts(String category, String... products) {
        List<String> categorized = dataSet.categorizedProducts().get(category);
        Assert.assertEquals(products.length, categorized.size());
        for (String product : products) {
            Assert.assertTrue(category + " did not have " + product, categorized.contains(product));
        }
    }

}
