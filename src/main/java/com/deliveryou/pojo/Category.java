package com.deliveryou.pojo;

import java.util.Locale;

public class Category {
    public static final Category OTHER = new Category(1, "Other");
    public static final Category FOOD = new Category(2, "Food");
    public static final Category FRAGILE = new Category(3, "Fragile");
    public static final Category ELECTRONICS = new Category(4, "Electronics");
    public static final Category CLOTHES = new Category(5, "Clothes");

    private int id;
    private String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Category getCategoryByName(String name) {
        if (name != null) {
            String val = name.trim();

            if (val.equalsIgnoreCase(FOOD.getName()))
                return FOOD;
            else if (val.equalsIgnoreCase(OTHER.getName()))
                return OTHER;
            else if (val.equalsIgnoreCase(CLOTHES.getName()))
                return CLOTHES;
            else if (val.equalsIgnoreCase(FRAGILE.getName()))
                return FRAGILE;
            else if (val.equalsIgnoreCase(ELECTRONICS.getName()))
                return ELECTRONICS;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
