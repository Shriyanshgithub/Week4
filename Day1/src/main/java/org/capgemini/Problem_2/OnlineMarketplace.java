package org.capgemini.Problem_2;

// Define product categories as marker interfaces
interface BookCategory {}
interface ClothingCategory {}
interface GadgetCategory {}

// Generic Product class with a bounded type parameter
class Product<T> {
    private String name;
    private double price;
    private T category; // Type-safe category

    // Constructor to initialize product details
    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Getter and setter for name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter for price
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    // Getter for category
    public T getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + ", category=" + category.getClass().getSimpleName() + "}";
    }
}

// Utility class for applying discounts
class DiscountUtility {
    // Generic method to apply a discount to a product
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountAmount = product.getPrice() * (percentage / 100);
        double newPrice = product.getPrice() - discountAmount;
        product.setPrice(newPrice);
        System.out.println("Discount applied! New price of " + product.getName() + ": $" + newPrice);
    }
}

// Sample categories
class Fiction implements BookCategory {}
class CasualWear implements ClothingCategory {}
class Smartphone implements GadgetCategory {}

// Main class to demonstrate functionality
public class OnlineMarketplace {
    public static void main(String[] args) {
        // Create products of different categories
        Product<BookCategory> book = new Product<>("The Alchemist", 15.99, new Fiction());
        Product<ClothingCategory> shirt = new Product<>("Casual T-Shirt", 25.99, new CasualWear());
        Product<GadgetCategory> phone = new Product<>("Smartphone X", 699.99, new Smartphone());

        // Print product details
        System.out.println(book);
        System.out.println(shirt);
        System.out.println(phone);

        // Apply discounts
        DiscountUtility.applyDiscount(book, 10); // 10% discount
        DiscountUtility.applyDiscount(shirt, 15); // 15% discount
        DiscountUtility.applyDiscount(phone, 20); // 20% discount
    }
}

