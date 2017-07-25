package com.lunch.streams;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public abstract class DataSetBase {

    public static final String BATH = "Bath";
    public static final String KITCHEN = "Kitchen";
    public static final String DAIRY = "Dairy";
    public static final String VEGETABLES = "Vegetables";

    public static final String APPLE = "Apple";
    public static final String FRUIT = "Fruit";
    public static final String SOAP = "Soap";
    public static final String ORANGE = "Orange";
    public static final String GRAPES = "Grapes";
    public static final String DAWN = "Dawn";
    public static final String CELERY = "Celery";
    public static final String WATERMELON = "Watermelon";
    public static final String HONEYDEW = "Honeydew";
    public static final String SPONGE = "Sponge";
    public static final String POTATO = "Potato";
    public static final String CHEESE = "Cheese";
    public static final String KIWI = "Kiwi";
    public static final String KNIFE = "Knife";
    public static final String MILK = "Milk";

    protected final List<Basket> baskets;

    public DataSetBase() {
        this.baskets = new ArrayList<>();

        // the first basket is not to be included, so it's content shouldn't be in the result
        baskets.add(new Basket(false, Arrays.asList(
                new Product(APPLE, FRUIT, true) // there should be no apples in the result
        )));

        // There shouldn't be any Bath products at all in the result because this is the only
        // code that adds any and it's marked for exclusion
        baskets.add(new Basket(false, Arrays.asList(
                new Product(BATH, SOAP, true)
        )));

        baskets.add(new Basket(true, Arrays.asList(
                new Product(APPLE, FRUIT, false), // not included.  Still no apples in the result
                new Product(ORANGE, FRUIT, true),
                new Product(GRAPES, FRUIT, true),
                new Product(DAWN, KITCHEN, true),
                new Product(CELERY, VEGETABLES, true)
        )));

        baskets.add(new Basket(true, Arrays.asList(
                new Product(WATERMELON, FRUIT, true),
                new Product(HONEYDEW, FRUIT, false), // not included
                new Product(SPONGE, KITCHEN, true),
                new Product(POTATO, VEGETABLES, true),
                new Product(CHEESE, DAIRY, true)
        )));

        baskets.add(new Basket(true, Arrays.asList(
                new Product(KIWI, FRUIT, true),
                new Product(KNIFE, KITCHEN, true),
                new Product(MILK, DAIRY, true)
        )));

        // Expected output of categorizedProducts:
        //  Fruit: Orange, Grapes, Watermelon, Kiwi
        //  Kitchen: Dawn, Sponge, Knife
        //  Vegetables: Celery, Potato
        //  Dairy: Cheese, Milk

    }

    /**
     * Returns a map of string categories to all product names that
     * match that category, but only if both the Basket and Product
     * are to be included.
     */
    public abstract Map<String, List<String>> categorizedProducts();

}

@Data
@AllArgsConstructor
class Basket {

    private boolean include;
    private List<Product> products;

}

@Data
@AllArgsConstructor
class Product {

    private String name;
    private String category;
    private boolean include;

}
