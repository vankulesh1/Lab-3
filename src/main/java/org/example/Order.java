package org.example;

import java.util.List;
import java.util.ArrayList;



public class Order {

    //Повинен мати атрибути, такі як `orderId`, `products`, `status`.
    private int orderId;
    private List<Product> products;
    private OrderStatus status;

//constr
public Order(int orderId, List<Product> products, OrderStatus status) {
    this.orderId = orderId;
    this.products = products;
    this.status = status;
}
//ввід / вивід
public int getOrderId() {
    return orderId;
}

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public OrderStatus getStatus() {
        return status;
    }

}
//статуси продуктів
enum OrderStatus {
    ACCEPTED,
    PROCESSING,
    PACKED,
    SENDING,
    DELIVERY
}