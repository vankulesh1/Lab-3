package org.example;

import java.util.List;
import java.util.ArrayList;

public class Cart {

    private List<Product> products;

    public Cart() {                          //constr
        this.products = new ArrayList<>();
    }
//вивести список товарів в кошику
    public List<Product> getProducts() {
        return products;
    }
    //додати товар в кошик
    public void addProduct(Product product) {
        this.products.add(product);
    }
//видалити товар з кошика
    public void removeProduct(Product product) {
        this.products.remove(product);
    }
}
