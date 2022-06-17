package de.maximilianmleziva;

import java.util.ArrayList;
import java.util.List;

class Buy {
    static void buyItem(String player,String item) {
        List<Integer> price = new ArrayList<>();
        Currency.remove(player, price);
        System.out.println("Buy " + item);
    }
}
