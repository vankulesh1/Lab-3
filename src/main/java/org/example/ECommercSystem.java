package org.example;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ECommercSystem {
    private static List<Order> ordersList = new ArrayList<>();

    public static void main(String[] args) {
        Cart cart = new Cart();

        Product firstProduct = new Product(100, "Lenovo", 1900.99);
        Product secondProduct = new Product(101, "Samsung", 3000.99);

        cart.addProduct(firstProduct);
        cart.addProduct(secondProduct);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add product to cart: ");
            System.out.println("2. Remove the product from the cart: ");
            System.out.println("3. Make an order: ");
            System.out.println("4. Check the order status: ");
            System.out.println("5. Display all products in the cart");
            System.out.println("0. Exit: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter the product ID:");
                    int productId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter the name of the product:");
                    String productName = scanner.nextLine();
                    System.out.println("Enter the price of the product:");
                    double productPrice = scanner.nextDouble();

                    Product newProduct = new Product(productId, productName, productPrice);
                    cart.addProduct(newProduct);
                    System.out.println("The product has been added to the cart\n.");
                    break;

                case 2:
                    System.out.println("Enter the product ID to remove:");
                    int removeProductId = scanner.nextInt();
                    scanner.nextLine();

                    Product productToRemove = new Product(removeProductId, "", 0);
                    cart.removeProduct(productToRemove);
                    System.out.println("The product has been removed from the cart.");
                    break;

                case 3:
                    Order newOrder = new Order(cart.getProducts());
                    System.out.println("The order has been created. Order ID: " + newOrder.getOrderId());
                    cart.clearCart();
                    ordersList.add(newOrder); // додаємо нове замовлення до списку
                    break;

                case 4:
                    System.out.println("Enter order ID to check status:");
                    int orderId = scanner.nextInt();
                    scanner.nextLine();

                    Order checkOrder = findOrderById(orderId, ordersList);

                    if (checkOrder != null) {
                        System.out.println("Order status " + orderId + ": " + checkOrder.getStatus());
                    } else {
                        System.out.println("Order with ID " + orderId + " not found.");
                    }
                    break;


                    case 5:
                    displayAllProducts(cart);
                    break;

                    case 0:
                    System.out.println("Thank you for using our ECommerceSystem.");
                    break;

                default:
                    System.out.println("Wrong choice. Try again.");
            }
        }
    }

    private static void displayAllProducts(Cart cart) {
        List<Product> products = cart.getProducts();
        if (products.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            System.out.println("Products in the cart:");
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }



    private static Order findOrderById(int orderId, List<Order> orders) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null;
    }
}