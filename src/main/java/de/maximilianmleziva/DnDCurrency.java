package de.maximilianmleziva;

import java.util.List;

public class DnDCurrency {
    public static void main(String[] args) {
        List<String> money = new Event("Max", 1, 2, 3, 4).asList();
        System.out.println(money);
    }
}
