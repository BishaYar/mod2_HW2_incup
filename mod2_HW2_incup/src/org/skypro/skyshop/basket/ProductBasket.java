package org.skypro.skyshop.basket;

import java.io.PrintStream;
import java.util.Arrays;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] product = new Product[5];

    public void addProductInBasket(Product addProduct) {
        for(int i = 0; i < this.product.length; ++i) {
            if (this.product[i] == null) {
                this.product[i] = addProduct;
                break;
            }
        }
    }

    public int getCostBasket() {
        int cost = 0;

        for(Product prod : this.product) {
            if (prod != null) {
                cost += prod.getPriceProduct();
            }
        }

        return cost;
    }

    public void printBasket() {
        int i = 0;

        for(Product prod : this.product) {
            if (prod != null) {
                ++i;
                PrintStream var10000 = System.out;
                String var10001 = prod.getNameProduct();
                var10000.println("<" + var10001 + ">: <" + prod.getPriceProduct() + ">");
            }
        }

        if (i > 0) {
            System.out.println("Итого: " + this.getCostBasket());
        } else {
            System.out.println("В корзине пусто");
        }
    }

    public boolean findProduct(String nameProd) {
        for(Product prod : this.product) {
            if (prod != null && prod.getNameProduct().equals(nameProd)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        Arrays.fill(product, null);
    }
}

