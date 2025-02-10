package org.capgemini.Problem_1;

public class SmartWarehouseSystem {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem((new Electronics("Smartphone")));

        groceriesStorage.addItem(new Groceries("Apple"));
        groceriesStorage.addItem(new Groceries("milk"));

        furnitureStorage.addItem(new Furniture("Sofa"));
        furnitureStorage.addItem((new Furniture("Table")));

        System.out.println("Display Electronics");
        WarehouseUtils.displayItems(electronicsStorage.getAllItems());

        System.out.println("\nGroceries:");
        WarehouseUtils.displayItems(groceriesStorage.getAllItems());

        System.out.println("\nFurniture:");
        WarehouseUtils.displayItems(furnitureStorage.getAllItems());
    }
}
