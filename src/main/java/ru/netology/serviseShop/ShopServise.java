package ru.netology.serviseShop;

import ru.netology.basket.Basket;
import ru.netology.product.Product;
import ru.netology.product.meat.Meat;
import ru.netology.product.milk.Milk;
import ru.netology.product.vegetables.Vegetables;

import java.util.ArrayList;
import java.util.Scanner;

public class ShopServise implements IShopServise {
    static ArrayList<Product> catalog = new ArrayList<>();
    Basket basket = new Basket();
    boolean orderSuccess = false;

    @Override
    public void start() {
        createCatalog();

        while (true) {
            if (orderSuccess) {
                break;
            }
            //DRY
            showMenu();
            Scanner scanner = new Scanner(System.in);
            int numberTask = 0;

            try {
                String task = scanner.nextLine();
                numberTask = Integer.parseInt(task);
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не число");
            }

            if (numberTask == 0) {
                break;
            }
            switch (numberTask) {
                case 1:
                    showCatalog();
                    break;
                case 2:
                    System.out.println("Введите номер товара из каталого:");
                    showCatalog();
                    String getIndexCatalog = scanner.nextLine();
                    int taskAddIndex = Integer.parseInt(getIndexCatalog);
                    if (taskAddIndex > catalog.size()) {
                        System.out.println("Указанного товара не существует, введите правильный номер");
                    } else {
                        basket.add(catalog.get(taskAddIndex - 1));
                        System.out.println("Товар " + catalog.get(taskAddIndex - 1) + " успешно добавлен в корзину");
                    }
                    break;
                case 3:
                    if (basket.getAll().isEmpty()) {
                        System.out.println("Вы недобавили товар в корзину");
                    } else {
                        System.out.println("Корзина:");
                        basket.showBasket();
                    }
                    break;
                case 4:
                    if (basket.getAll().isEmpty()) {
                        System.out.println("Вы недобавили товар в корзину");
                    } else {
                        System.out.println("Введите номер товра для удаления:");
                        basket.showBasket();
                        String taskRemoveString = scanner.nextLine();
                        int taskRemoveIndex = Integer.parseInt(taskRemoveString);
                        int findTask = basket.getAll().indexOf(basket.getAll().get(taskRemoveIndex));
                        if (findTask != -1) {
                            basket.remove(findTask - 1);
                            basket.showBasket();
                        } else {
                            System.out.println("Указанного товара не существует, введите правильный номер товра");
                        }
                    }
                    break;
                case 5:
                    if (basket.getAll().isEmpty()) {
                        System.out.println("Для оформления заказа нужно добавить товар в корзину");
                    } else {
                        orderSuccess = true;
                        System.out.println("Заказ успешно оформлен");
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
    }


    @Override
    public void showCatalog() {
        System.out.println("Каталог продуктов:");
        for (int i = 0; i < catalog.size(); i++) {
            System.out.printf("%d. %s \n", i + 1, catalog.get(i));
        }
    }

    @Override
    public void showMenu() {
        System.out.println("");
        System.out.println("0. Выход из магазина");
        System.out.println("1. Посмотреть каталог");
        System.out.println("2. Добавить товар в корзину ");
        System.out.println("3. Посмотреть корзины");
        System.out.println("4. Удалить товар из корзины");
        System.out.println("5. Оформить заказ");
    }

    @Override
    public void createCatalog() {
        Product product1 = new Vegetables("Картофель", 30, true);
        Product product2 = new Vegetables("Лук", 40, false);
        Product product3 = new Milk("Молоко", 70, 1.2);
        Product product4 = new Meat("Мясо", 200, 1);

        catalog.add(product1);
        catalog.add(product2);
        catalog.add(product3);
        catalog.add(product4);
    }
}
