package de.maximilianmleziva;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MapTest {
    @Test
    @DisplayName("Füge einen neuen Eintrag hinzu.")
     void test1() {
        HashMap<String, List<Integer>> map = new HashMap<>();
        String key = "key";
        List<Integer> list = List.of(1, 2, 3, 4);
        map.put(key, list);
        CurrencyMap.updateMap(key, list);
        assertThat(CurrencyMap.map).isEqualTo(map);
    }

    @Test
    @DisplayName("Update einen gegebenen Eintrag.")
    void test2() {
        HashMap<String, List<Integer>> map = new HashMap<>();
        String key = "key";
        List<Integer> list = List.of(1, 2, 3, 4);
        List<Integer> list2 = List.of(0, 41, 6, 6);
        map.put(key, list2);
        CurrencyMap.updateMap(key, list);
        CurrencyMap.updateMap(key, list2);
        assertThat(CurrencyMap.map).isEqualTo(map);
    }

    @Test
    @DisplayName("Mehrere Einträge.")
    void test3() {
        HashMap<String, List<Integer>> map = new HashMap<>();
        String key = "key";
        List<Integer> list = List.of(1, 2, 3, 4);
        String key2 = "key2";
        List<Integer> list2 = List.of(0, 41, 6, 6);
        map.put(key, list);
        map.put(key2, list2);
        CurrencyMap.updateMap(key, list);
        CurrencyMap.updateMap(key2, list2);
        assertThat(CurrencyMap.map).isEqualTo(map);
    }

}