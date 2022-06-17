package de.maximilianmleziva;

import java.util.HashMap;
import java.util.List;

class CurrencyMap {
    static HashMap<String, List<Integer>> map = new HashMap<>();

    static void updateMap(String key, List<Integer> value) {
        map.put(key, value);
    }

    static void setMap(HashMap<String, List<Integer>> map) {
        CurrencyMap.map = map;
    }
}
