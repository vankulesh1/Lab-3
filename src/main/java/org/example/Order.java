package org.example;

import java.util.List;

public class Order {

    //Повинен мати атрибути, такі як `orderId`, `products`, `status`.
    public int orderId;
    public List<Product> products;
    public String status;

//constr
public Order(int orderId, List<Product> products, String status) {
    this.orderId = orderId;
    this.products = products;
    this.status = status;
}

}
