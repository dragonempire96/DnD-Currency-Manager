package de.maximilianmleziva;

import java.util.List;

class Currency {
    static void add(String player, List<Integer> addedCurrency) {
        List<Integer> currentCurrency = CurrencyMap.map.get(player);
        List<Integer> currencyNew = List.of(currentCurrency.get(0) + addedCurrency.get(0),
                currentCurrency.get(1) + addedCurrency.get(1),
                currentCurrency.get(2) + addedCurrency.get(2),
                currentCurrency.get(3) + addedCurrency.get(3));
        CurrencyMap.updateMap(player, currencyNew);
    }

    static void remove(String player, List<Integer> removedCurrency) {
        List<Integer> currentCurrency = currentCurrency(player);
        //TODO: check if currentCurrency is greater than removedCurrency
        List<Integer> currencyNew = List.of(currentCurrency.get(0) - removedCurrency.get(0),
                currentCurrency.get(1) - removedCurrency.get(1),
                currentCurrency.get(2) - removedCurrency.get(2),
                currentCurrency.get(3) - removedCurrency.get(3));
        CurrencyMap.updateMap(player, currencyNew);
    }

    static int convert(String player, int money, String from, String to) {
        int currencyValue;
        List<Integer> removedCurrency;
        switch (from) {
            case "PM" -> {
                currencyValue = convertPlatinum(player, money, to);
                removedCurrency = List.of(money, 0, 0, 0);
            }
            case "GM" -> {
                currencyValue = convertGold(player, money, to);
                removedCurrency = List.of(0, money, 0, 0);
            }
            case "SM" -> {
                currencyValue = convertSilver(player, money, to);
                removedCurrency =  List.of(0, 0, money, 0);
            }
            case "KM" -> {
                currencyValue = convertCopper(player, money, to);
                removedCurrency =  List.of(0, 0, 0, money);
            }
            default -> {
                System.out.println("Invalid currency");
                currencyValue = -1;
                removedCurrency = List.of(0, 0, 0, 0);
            }
        }
        remove(player, removedCurrency);
        return currencyValue;
    }

    private static List<Integer> currentCurrency(String player) {
        return CurrencyMap.map.get(player);
    }

    private static int convertPlatinum(String player, int money, String to) {
        int moneyNew;
        switch (to) {
            case "GM" -> {
                moneyNew = money * 10;
                add(player, List.of(0,moneyNew, 0, 0));
            }
            case "SM" -> {
                moneyNew = money * 100;
                add(player,List.of(0, 0, moneyNew, 0));
            }
            case "KM" -> {
                moneyNew = money * 1000;
                add(player, List.of(0, 0, 0, moneyNew));
            }
            default -> {
                moneyNew = money;
                add(player, List.of(moneyNew, 0, 0, 0));
            }
        }
        return moneyNew;
    }

    private static int convertGold(String player, int money, String to) {
        int moneyNew;
        switch (to) {
            case "PM" -> {
                moneyNew = money / 10;
                add(player, List.of(moneyNew, 0, 0, 0));
            }
            case "SM" -> {
                moneyNew = money * 10;
                add(player, List.of(0, 0, moneyNew, 0));
            }
            case "CM" -> {
                moneyNew = money * 100;
                add(player, List.of(0, 0, 0, moneyNew));
            }
            default -> {
                moneyNew = money;
                add(player, List.of(0, moneyNew, 0, 0));
            }
        }
        return moneyNew;
    }

    private static int convertSilver(String player, int money, String to) {
        int moneyNew;
        switch (to) {
            case "PM" -> {
                moneyNew = money / 100;
                add(player, List.of(moneyNew, 0, 0, 0));
            }
            case "GM" -> {
                moneyNew = money / 10;
                add(player, List.of(0, moneyNew, 0, 0));
            }
            case "KM" -> {
                moneyNew = money * 10;
                add(player, List.of(0, 0, 0, moneyNew));
            }
            default -> {
                moneyNew = money;
                add(player, List.of(0, 0, moneyNew, 0));
            }
        }
        return moneyNew;
    }

    private static int convertCopper(String player, int money, String to) {
        int moneyNew;
        switch (to) {
            case "PM" -> {
                moneyNew = money / 1000;
                add(player, List.of(moneyNew, 0, 0, 0));
            }
            case "GM" -> {
                moneyNew = money / 100;
                add(player, List.of(0, moneyNew, 0, 0));
            }
            case "SM" -> {
                moneyNew = money / 10;
                add(player, List.of(0, 0, moneyNew, 0));
            }
            default -> {
                moneyNew = money;
                add(player, List.of(0, 0, 0, moneyNew));
            }
        }
        return moneyNew;
    }
}
