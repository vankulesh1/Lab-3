//tests
package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ECommercSystemTest{

     @Test
    public void testAddProductToCart() {

        Product product = mock(Product.class);

        when(product.getId()).thenReturn(1);
        when(product.getName()).thenReturn("TestProduct");
        when(product.getPrice()).thenReturn(10.0);

        Cart cart = new Cart();
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