package org.capgemini.Problem_1;
import java.util.ArrayList;
import java.util.List;

// Generic Storage class for managing warehouse items
class Storage<T extends WarehouseItem> {
    private List<T> items;

    public Storage() {
        items = new ArrayList<>();
    }

    // Method to add an item to the storage
    public void addItem(T item) {
        items.add(item);
    }

    // Method to retrieve an item by index
    public T getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    // Method to get all items in storage
    public List<T> getAllItems() {
        return items;
    }
}

// Utility class to display all items using wildcards
class WarehouseUtils {
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }
}
