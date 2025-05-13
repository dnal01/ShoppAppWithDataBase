package org.example.entities;

import java.util.Map;

public class Menu {
    private final Map<Integer, String> menu = Map.of(1, "Add an entity", 2, "Read entities", 3, "Read an entity by id", 4, "Update an entity", 5, "Delete an entity", 0, "Exit");

    public Map<Integer, String> getMenu() {
        return menu;
    }
}
