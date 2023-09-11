package ru.netology.basket;

import ru.netology.product.Product;

import java.util.ArrayList;
import java.util.List;

// Solod O
// Solod D
public class Basket implements IBasket, IShowBacket {
    // Solod S
    List<Product> list = new ArrayList<>();

    public Basket() {
    }

    @Override
    public void add(Product product) {
        if (list.contains(product)) {
            int index = list.indexOf(product);
            list.get(index).incrementCount();
        } else {
            list.add(product);
        }
    }

    @Override
    public List<Product> getAll() {
        return list;
    }

    @Override
    public void remove(int index) {
        list.remove(index);
    }

    @Override
    public String toString() {
        return "Basket " + list +'}';
    }

    @Override
    public void showBasket() {
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d. %s \n", i + 1, list.get(i));
        }
    }
}
