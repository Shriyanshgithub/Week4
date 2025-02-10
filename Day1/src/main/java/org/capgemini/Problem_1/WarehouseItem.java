package org.capgemini.Problem_1;

// Abstract class representing a warehouse item
public abstract class WarehouseItem {
    private String name; // Name of the warehouse item

    // Constructor to initialize the name
    WarehouseItem(String name) {
        this.name = name;
    }

    // Getter method for the name
    public String getName() {
        return name;
    }

    // Setter method for the name
    public void setName(String name) {
        this.name = name;
    }

    // Returns a string representation of the item
    @Override
    public String toString() {
        return "Name of item is : " + name;
    }
}
