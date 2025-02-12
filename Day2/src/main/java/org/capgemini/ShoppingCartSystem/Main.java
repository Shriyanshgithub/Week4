package org.capgemini.ShoppingCartSystem;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Add products to the cart
        cart.addProduct("Apple", 1.5);
        cart.addProduct("Banana", 0.75);
        cart.addProduct("Orange", 1.2);
        cart.addProduct("Grapes", 2.0);
        cart.addProduct("Banana", 0.8); // Overwrite price for Banana

        // Display all products (HashMap)
        cart.displayAllProducts();

        // Display products in the order they were added (LinkedHashMap)
        cart.displayProductsInOrder();

        // Display products sorted by price (TreeMap)
        cart.displayProductsSortedByPrice();

        // Remove a product
        System.out.println("\nRemoving 'Banana'...");
        cart.removeProduct("Banana");

        // Display the cart after removal
        cart.displayAllProducts();
        cart.displayProductsInOrder();
        cart.displayProductsSortedByPrice();
    }
}

