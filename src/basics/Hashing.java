package basics;

import java.util.HashMap;
import java.util.Map;

public class Hashing {
    public static void main(String[] args) {
        printFrequencyOfEachElement(new int[]{1, 2, 3, 3, 2, 1, 4, 4, 5, 3, 2, 1});
    }

    // hashmap
    private static void printFrequencyOfEachElement(int[] arr) {
//        printFrequencyOfEachElement(new int[]{1, 2, 3, 3, 2, 1, 4, 4, 5, 3, 2, 1});
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        map.forEach((k, v) -> {
            System.out.println(k + " -> " + v);
        });
    }
}
