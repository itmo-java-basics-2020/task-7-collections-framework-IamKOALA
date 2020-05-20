package ru.ifmo.collections;

import java.util.Collections;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
public class KthLargest {
    private int k;
    private TreeMap<Integer, Integer> sMap = new TreeMap<Integer, Integer>(Collections.reverseOrder());

    public KthLargest(int k, int[] numbers) {
        this.k = k;

        for (int i : numbers) {
            if (!sMap.containsKey(i)) {
                sMap.put(i, 1);
            }
            else {
                sMap.put(i, sMap.get(i) + 1);
            }
        }
    }

    public int add(int val) {
        Integer prev = sMap.get(val);
        sMap.put(val, prev == null ? 1 : prev + 1);

        int cnt = 0;

        for(Map.Entry<Integer, Integer> e : sMap.entrySet()) {
            for(int i = 0; i < e.getValue(); i++) {
                cnt++;
                if(cnt == k) {
                    return e.getKey();
                }
            }
        }

        return -1;
    }
}