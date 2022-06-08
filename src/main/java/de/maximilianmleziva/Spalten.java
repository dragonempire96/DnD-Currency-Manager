package de.maximilianmleziva;

import java.util.List;

enum Spalten {
    CHARACTER, PLATINUM, GOLD, SILVER, COPPER;
    public static List<String> asList() {
        return List.of(
                Spalten.CHARACTER.toString(),
                Spalten.PLATINUM.toString(),
                Spalten.GOLD.toString(),
                Spalten.SILVER.toString(),
                Spalten.COPPER.toString()
        );
    }
}
