package de.maximilianmleziva;

import java.util.ArrayList;
import java.util.List;

class Currency {
    static void add(String player, List<Integer> addedCurrency) {
        System.out.println("Add");
        List<Integer> currentCurrency = CurrencyMap.map.get(player);
        List<Integer> currencyNew = new ArrayList<>();
        CurrencyMap.updateMap(player, currencyNew);
    }

    static void remove(String player, List<Integer> removedCurrency) {
        System.out.println("Remove");
        List<Integer> currentCurrency = CurrencyMap.map.get(player);
        List<Integer> currencyNew = new ArrayList<>();
        CurrencyMap.updateMap(player, currencyNew);
    }

    static void convert(String player,int money, String from, String to) {
        System.out.println("Convert");
        List<Integer> currentCurrency = CurrencyMap.map.get(player);
        List<Integer> currencyNew = new ArrayList<>();
        CurrencyMap.updateMap(player, currencyNew);
    }
}
