<<<<<<< HEAD
//tests
=======
>>>>>>> origin/master
package org.example;
import org.example.Cart;
import org.example.Product;
import org.example.Order;
import org.example.OrderStatus;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class ECommercSystemTest{

    @Test
    public void testAddProductToCart() {
        Cart cart = new Cart();
        Product product = new Product(1, "TestProduct", 10.0);
        cart.addProduct(product);
        assertTrue(cart.getProducts().contains(product));
    }

    @Test
    public void testRemoveProductFromCart() {
        Cart cart = new Cart();
        Product product = new Product(1, "TestProduct", 10.0);
        cart.addProduct(product);
        cart.removeProduct(product);
        assertFalse(cart.getProducts().contains(product));
    }

    @Test
    public void testPlaceOrder() {
        Cart cart = new Cart();
        Product product = new Product(1, "TestProduct", 10.0);
        cart.addProduct(product);
        Order order = new Order(cart.getProducts());
        assertNotNull(order);
        assertEquals(1, order.getProducts().size());
        assertEquals(OrderStatus.PLACED, order.getStatus());
    }

    @Test
    public void testCheckOrderStatus() {
        Cart cart = new Cart();
        Product product = new Product(1, "TestProduct", 10.0);
        cart.addProduct(product);
        Order order = new Order(cart.getProducts());
        int orderId = order.getOrderId();
        List<Order> ordersList = new ArrayList<>();
        ordersList.add(order);

        Order checkOrder = ECommercSystem.findOrderById(orderId, ordersList);

        assertNotNull(checkOrder);
        assertEquals(OrderStatus.PLACED, checkOrder.getStatus());
    }
}