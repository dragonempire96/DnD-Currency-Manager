package de.maximilianmleziva;

import java.util.List;

class Currency {
    static void add(String player, List<Integer> addedCurrency) {
        System.out.println("Add");
        List<Integer> currentCurrency = CurrencyMap.map.get(player);
        List<Integer> currencyNew = List.of(currentCurrency.get(0) + addedCurrency.get(0),
                currentCurrency.get(1) + addedCurrency.get(1),
                currentCurrency.get(2) + addedCurrency.get(2),
                currentCurrency.get(3) + addedCurrency.get(3));
        CurrencyMap.updateMap(player, currencyNew);
    }

    static void remove(String player, List<Integer> removedCurrency) {
        System.out.println("Remove");
        List<Integer> currentCurrency = currentCurrency(player);
        List<Integer> currencyNew = List.of(currentCurrency.get(0) - removedCurrency.get(0),
                currentCurrency.get(1) - removedCurrency.get(1),
                currentCurrency.get(2) - removedCurrency.get(2),
                currentCurrency.get(3) - removedCurrency.get(3));
        CurrencyMap.updateMap(player, currencyNew);
    }

    /*static void convert(String player,int money, String from, String to) {
        System.out.println("Convert");
        List<Integer> currentCurrency = CurrencyMap.map.get(player);
        List<Integer> currencyNew = new ArrayList<>();
        CurrencyMap.updateMap(player, currencyNew);
    }*/

    private static List<Integer> currentCurrency(String player) {
        return CurrencyMap.map.get(player);
    }
}
