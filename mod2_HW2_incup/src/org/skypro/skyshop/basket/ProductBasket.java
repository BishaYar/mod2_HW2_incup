package org.skypro.skyshop.basket;

import java.util.*;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Map<String, Set<Product>> mapProdBasket = new HashMap<>();

    public void addProductInBasket(String nameProd, Product product) {
        mapProdBasket.computeIfAbsent(nameProd, k->new HashSet<>()).add(product);
    }

    public Set<Product> deleteProductInBasket(String name) {
        return mapProdBasket.remove(name);
    }

    public int getCostBasket() {
        return mapProdBasket.values().stream().flatMap(Collection::stream)
                .mapToInt(Product::getPriceProduct).sum();
    }

    public void printBasket() {
        if (mapProdBasket.isEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            mapProdBasket.values().stream().flatMap(Collection::stream)
                    .filter(Objects::nonNull)
                    .forEach(System.out::println);
            System.out.println("Итого: " + this.getCostBasket());
        }
    }
}