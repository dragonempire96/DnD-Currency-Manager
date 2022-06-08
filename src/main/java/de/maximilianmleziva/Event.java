package de.maximilianmleziva;

import org.apache.commons.csv.CSVRecord;

import java.util.List;

record Event(String character, int platinum, int gold, int silver, int copper) {
    Event(CSVRecord record) {
        this(
                record.get(Spalten.CHARACTER),
                Integer.parseInt(record.get(Spalten.PLATINUM)),
                Integer.parseInt(record.get(Spalten.GOLD)),
                Integer.parseInt(record.get(Spalten.SILVER)),
                Integer.parseInt(record.get(Spalten.COPPER))
        );
    }

    public List<String> asList() {
        return List.of(this.character, String.valueOf(this.platinum), String.valueOf(this.gold), String.valueOf(this.silver),String.valueOf(this.copper));
    }
}
