package ru.netology.product.meat;

import ru.netology.product.Product;

// Solod L
public class Meat extends Product {
    int weight;

    public Meat(String name, int amount, int weight) {
        super(name, amount);
        this.weight = weight;
    }

    public Meat(String name, int count, int amount, int weight) {
        super(name, count, amount);
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name + " вec " + weight + "кг" + " цена:" + amount + "руб";

    }
}
