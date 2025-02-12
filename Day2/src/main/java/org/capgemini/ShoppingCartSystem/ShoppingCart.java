package org.capgemini.ShoppingCartSystem;

import java.util.*;

public class ShoppingCart {
    private Map<String, Double> productPricesHashMap = new HashMap<>();
    private Map<String, Double> productPricesLinkedHashMap = new LinkedHashMap<>();
    private TreeMap<Double, List<String>> productPricesTreeMap = new TreeMap<>();

    // Method to add a product to the cart
    public void addProduct(String product, double price) {
        // Add to HashMap
        productPricesHashMap.put(product, price);

        // Add to LinkedHashMap
        productPricesLinkedHashMap.put(product, price);

        // Add to TreeMap (grouped by price)
        productPricesTreeMap.computeIfAbsent(price, k -> new ArrayList<>()).add(product);
    }

    // Method to remove a product from the cart
    public void removeProduct(String product) {
        // Remove from HashMap
        Double price = productPricesHashMap.remove(product);

        // Remove from LinkedHashMap
        productPricesLinkedHashMap.remove(product);

        // Remove from TreeMap
        if (price != null) {
            List<String> products = productPricesTreeMap.get(price);
            products.remove(product);
            if (products.isEmpty()) {
                productPricesTreeMap.remove(price);
            }
        }
    }

    // Method to display all products (HashMap)
    public void displayAllProducts() {
        System.out.println("\nAll Products (HashMap):");
        for (Map.Entry<String, Double> entry : productPricesHashMap.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }

    // Method to display products in the order they were added (LinkedHashMap)
    public void displayProductsInOrder() {
        System.out.println("\nProducts in Order Added (LinkedHashMap):");
        for (Map.Entry<String, Double> entry : productPricesLinkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }

    // Method to display products sorted by price (TreeMap)
    public void displayProductsSortedByPrice() {
        System.out.println("\nProducts Sorted by Price (TreeMap):");
        for (Map.Entry<Double, List<String>> entry : productPricesTreeMap.entrySet()) {
            for (String product : entry.getValue()) {
                System.out.println(product + ": $" + entry.getKey());
            }
        }
    }
}

