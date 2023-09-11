package ru.netology.basket;

import ru.netology.product.Product;

import java.util.List;

public interface IBasket {
    void add(Product product);
    void remove(int index);
    List<Product> getAll();
}
