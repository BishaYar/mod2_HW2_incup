package org.skypro.skyshop.basket;

import java.util.*;
import java.util.stream.Stream;

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
        int cost;
        try (Stream<Product> productStream = mapProdBasket.values().stream().flatMap(Collection::stream)) {
            cost = productStream.mapToInt(Product::getPriceProduct).sum();
        }
        return cost;
    }

    public void printBasket() {
        int i = 0;
        Stream<Product> productStream = mapProdBasket.values().stream().flatMap(Collection::stream);

        Stream<Product> stream = productStream.filter(Objects::nonNull);

        for (Product el : stream.toList())
        {
            i++;
            System.out.println(el.getText() + " " + el.getPriceProduct());
        }
        if (i > 0) {
            System.out.println("Итого: " + this.getCostBasket());
        } else {
            System.out.println("В корзине пусто");
        }
    }
}