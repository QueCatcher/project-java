// SportEquipment.java
package org.example;

public class SportEquipment {
    private static int lastId = 0;

    private int id;
    private String name;
    private String description;
    private double price;
    private boolean availability;

    public SportEquipment(String name, String description, double price, boolean availability) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.availability = availability;

        // Aktualizacja lastId, aby unikać konfliktów z nadchodzącymi dodawanymi sprzętami
        lastId = Math.max(lastId, id);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public void displayDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Description: " + description);
        System.out.println("Price: " + price);
        System.out.println("Availability: " + (availability ? Colors.GREEN + "Available" + Colors.RESET : Colors.RED + "Not Available" + Colors.RESET));
    }
}
