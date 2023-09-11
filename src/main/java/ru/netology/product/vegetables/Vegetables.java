package ru.netology.product.vegetables;

import ru.netology.product.Product;
// Solod L
public class Vegetables extends Product {
    Boolean fresh;

    public Vegetables(String name, int amount, Boolean fresh) {
        super(name, amount);
        this.fresh = fresh;
    }

    public Vegetables(String name, int count, int amount, Boolean fresh) {
        super(name, count, amount);
        this.fresh = fresh;
    }

    @Override
    public String toString() {
        return name + " цена:" + amount+ "руб" + " свежие " + (fresh ? "да" : "нет");
    }
}
