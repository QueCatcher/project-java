package org.example;

public class Messages {
    public static void displayWelcomeMessage() {
        System.out.println(Colors.BLUE + "Welcome to the Sports Equipment Management Program!" + Colors.RESET);
    }

    public static void displayMenu() {
        System.out.println("\nChoose an option:");
        System.out.println("1. Add new sports equipment");
        System.out.println("2. Display available sports equipment");
        System.out.println("3. Update available sports equipment");
        System.out.println("4. Delete available sports equipment");
        System.out.println("5. Exit the program");
        System.out.print("Your choice: ");
    }

    public static void displayExitMessage() {
        System.out.println(Colors.BLUE + "Thank you for using the program. Goodbye!" + Colors.RESET);
    }

    public static void displayInvalidChoiceMessage() {
        System.out.println(Colors.RED + "Invalid choice. Please try again." + Colors.RESET);
    }

    public static void displayAddingEquipmentMessage() {
        System.out.println("\nAdding new sports equipment:");
    }

    public static void displayEquipmentAvailableList() {
        System.out.println("\nAvaliable sports equipment:");
    }
}
