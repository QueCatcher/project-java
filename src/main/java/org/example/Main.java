package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<SportEquipment> equipmentList = DataHandler.loadData();

        // Sprawdź czy lista jest null, jeśli tak, utwórz nową listę
        if (equipmentList == null) {
            equipmentList = DataHandler.createEmptyList();
        }

        Messages.displayWelcomeMessage();

        while (true) {
            Messages.displayMenu();

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consuming the newline character

            switch (choice) {
                case 1:
                    Messages.displayAddingEquipmentMessage();
                    EquipmentManager.addNewEquipment(scanner, equipmentList);
                    // Po dodaniu nowego sprzętu, zapisz listę do pliku
                    DataHandler.saveData(equipmentList);
                    break;

                case 2:
                    Messages.displayEquipmentAvailableList();
                    for (SportEquipment equipment : equipmentList) {
                        if (equipment.isAvailable()) {
                            equipment.displayDetails();
                        }
                    }
                    break;

                case 3:
                    Messages.displayExitMessage();
                    System.exit(0);

                default:
                    Messages.displayInvalidChoiceMessage();
                    break;
            }
        }
    }
}
