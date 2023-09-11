package ru.netology.product.milk;

import ru.netology.product.Product;
// Solod L
public class Milk extends Product {
    Double volume;

    public Milk(String name, int amount, Double volume) {
        super(name, amount);
        this.volume = volume;
    }

    public Milk(String name, int count, int amount, Double volume) {
        super(name, count, amount);
        this.volume = volume;
    }

    @Override
    public String toString() {
        return name + " объем " + volume + " цена:" + amount + "руб";
    }
}
