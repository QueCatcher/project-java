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
    public static void updateEquipment(Scanner scanner, List<SportEquipment> equipmentList) {
        System.out.print("Enter the ID of the equipment to update: ");
        int idToUpdate = scanner.nextInt();

        SportEquipment equipmentToUpdate = findEquipmentById(equipmentList, idToUpdate);
        if (equipmentToUpdate != null) {
            // Modyfikacja wybranego sprzętu
            System.out.print("Enter new name: ");
            equipmentToUpdate.setName(scanner.nextLine());

            System.out.print("Enter new description: ");
            equipmentToUpdate.setDescription(scanner.nextLine());

            System.out.print("Enter new price: ");
            equipmentToUpdate.setPrice(scanner.nextDouble());
            scanner.nextLine();  // Consuming the newline character

            System.out.print("Is it still available? (true/false): ");
            equipmentToUpdate.setAvailability(scanner.nextBoolean());

            System.out.println("Equipment updated successfully:");
            equipmentToUpdate.displayDetails();
        } else {
            System.out.println("Equipment with ID " + idToUpdate + " not found.");
        }
    }

    public static void removeEquipment(Scanner scanner, List<SportEquipment> equipmentList) {
        System.out.print("Enter the ID of the equipment to remove: ");
        int idToRemove = scanner.nextInt();

        SportEquipment equipmentToRemove = findEquipmentById(equipmentList, idToRemove);
        if (equipmentToRemove != null) {
            equipmentList.remove(equipmentToRemove);
            System.out.println("Equipment removed successfully.");
        } else {
            System.out.println("Equipment with ID " + idToRemove + " not found.");
        }
    }

    private static SportEquipment findEquipmentById(List<SportEquipment> equipmentList, int id) {
        for (SportEquipment equipment : equipmentList) {
            if (equipment.getId() == id) {
                return equipment;
            }
        }
        return null;
    }
}
