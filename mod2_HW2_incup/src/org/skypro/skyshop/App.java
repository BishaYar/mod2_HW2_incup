package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product prod1 = new Product("кофе", 500);
        Product prod2 = new Product("молоко", 100);
        Product prod3 = new Product("печенье", 200);
        Product prod4 = new Product("рыба", 300);
        Product prod5 = new Product("колбаса", 250);
        Product prod6 = new Product("яйца", 100);

        ProductBasket basket1 = new ProductBasket();
        //1 Добавление продукта в корзину.
        basket1.addProductInBasket(prod1);
        basket1.addProductInBasket(prod6);
        basket1.addProductInBasket(prod3);
        basket1.addProductInBasket(prod4);
        basket1.addProductInBasket(prod2);

        //2 Добавление продукта в заполненную корзину, в которой нет свободного места.
        basket1.addProductInBasket(prod5);

        System.out.println("=== 3 Печать содержимого корзины с несколькими товарами ===");
        basket1.printBasket();

        System.out.println("=== 4 Получение стоимости корзины с несколькими товарами ===");
        System.out.println("Стоимость корзины: " + basket1.getCostBasket());

        System.out.println("=== 5 Поиск товара, который есть в корзине ===");
        System.out.println(basket1.findProduct("кофе"));

        System.out.println("=== 6 Поиск товара, которого нет в корзине ===");
        System.out.println(basket1.findProduct("макароны"));

        //7 Очистка корзины.
        basket1.clearBasket();

        System.out.println("=== 8 Печать содержимого пустой корзины ===");
        basket1.printBasket();

        System.out.println("=== 9 Получение стоимости пустой корзины ===");
        System.out.println("Стоимость корзины: " + basket1.getCostBasket());

        System.out.println("=== 10 Поиск товара по имени в пустой корзине ===");
        System.out.println(basket1.findProduct("макароны"));
    }
}

