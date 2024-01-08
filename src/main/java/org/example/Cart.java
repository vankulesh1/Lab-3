package org.example;

import java.util.List;
import java.util.ArrayList;

public class Cart {

    private List<Product> products;

    public Cart() {                          //constr
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }
    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }
}
