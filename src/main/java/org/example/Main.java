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
                    //Zapis nowego sprzętu po poprawnym dodaniu go podczas działania programu
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
                    EquipmentManager.updateEquipment(scanner, equipmentList);
                    // Po aktualizacji sprzętu, zapisz listę do pliku
                    DataHandler.saveData(equipmentList);
                    break;

                case 4:
                    EquipmentManager.removeEquipment(scanner, equipmentList);
                    // Po usunięciu sprzętu, zapisz listę do pliku
                    DataHandler.saveData(equipmentList);
                    break;

                case 5:
                    Messages.displayExitMessage();
                    System.exit(0);

                default:
                    Messages.displayInvalidChoiceMessage();
                    break;
            }
        }
    }
}
