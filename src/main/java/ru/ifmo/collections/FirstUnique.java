package ru.ifmo.collections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {
    private LinkedHashMap<Integer, Boolean> map = new LinkedHashMap<Integer, Boolean>();

    public FirstUnique(int[] numbers) {
        for (int i : numbers) {
            this.add(i);
        }
    }

    public int showFirstUnique() {
        for (Map.Entry<Integer, Boolean> e : map.entrySet()) {
            if(e.getValue()) {
                return e.getKey();
            }
        }

        return -1;
    }

    public void add(int value) {
        map.put(value, map.get(value) == null);
    }
}
