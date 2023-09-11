package ru.netology.product;

public class Product implements IProduct{
    protected  String name;
    protected  int count;
    protected  int amount;

    public Product(String name,  int amount) {
        this.name = name;
        this.amount = amount;
    }
    public Product(String name,  int amount ,int count) {
        this.name = name;
        this.count = count;
        this.amount = amount;
    }
    public String getName() {
        return this.name;
    }

    public int getCount() {
        return this.count;
    }

    public int getAmount() {
        return this.amount;
    }

    public void incrementCount() {
        this.count++;
    }

}
