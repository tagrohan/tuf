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

        // highest and lowest frequesncy element
        // here we need to keep the recors of both key and frequesncy so that we can compare and changes based on that
        Pair min = new Pair(0, Integer.MAX_VALUE);
        Pair max = new Pair(0, Integer.MIN_VALUE);

        for (Integer i : map.keySet()) {
            if (map.get(i) > max.getFreq()) {
                max.setKey(i);
                max.setFreq(map.get(i));
            }
            if (map.get(i) < min.getFreq()) {
                min.setKey(i);
                min.setFreq(map.get(i));
            }

        }
        System.out.println("Max is " + max.getKey() + ", Min is " + min.getKey());
    }

    static class Pair {
        int key;
        int freq;

        public Pair(int key, int freq) {
            this.key = key;
            this.freq = freq;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getFreq() {
            return freq;
        }

        public void setFreq(int freq) {
            this.freq = freq;
        }
    }
}
