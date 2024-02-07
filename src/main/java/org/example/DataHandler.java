package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DataHandler {
    private static final String FILE_PATH = "equipment.json";
    private static final Gson gson = new Gson();

    public static void saveData(List<SportEquipment> equipmentList) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(equipmentList, writer);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error saving data.");
        }
    }

    public static List<SportEquipment> loadData() {
        // Sprawdź istnienie pliku, jeśli nie istnieje, utwórz go
        checkFileExistence();

        try (Reader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<List<SportEquipment>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading data.");
        }

        return null; // Zwróć null w przypadku błędu lub braku pliku
    }

    private static void checkFileExistence() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error creating file.");
            }
        }
    }

    public static List<SportEquipment> createEmptyList() {
        return new ArrayList<>();
    }
}
