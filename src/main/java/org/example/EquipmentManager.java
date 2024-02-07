package org.example;

import java.util.List;
import java.util.Scanner;

public class EquipmentManager {
    public static void addNewEquipment(Scanner scanner, List<SportEquipment> equipmentList) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();  // Consuming the newline character
        System.out.print("Is it available? (true/false): ");
        boolean availability = scanner.nextBoolean();

        SportEquipment newEquipment = new SportEquipment(name, description, price, availability);
        equipmentList.add(newEquipment);

        Messages.displayAddingEquipmentMessage();
        newEquipment.displayDetails();
    }
}
