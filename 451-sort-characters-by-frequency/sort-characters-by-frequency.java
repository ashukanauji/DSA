class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> charFrequencies = new HashMap<>();
        for (char c : s.toCharArray()) {
            charFrequencies.put(c, charFrequencies.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue()
        );
        maxHeap.addAll(charFrequencies.entrySet());

        StringBuilder sortedString = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                sortedString.append(entry.getKey());
            }
        }
        return sortedString.toString();



        /* 
            import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {

    public static String frequencySort(String s) {
        Map<Character, Integer> charFrequencies = new HashMap<>();
        for (char c : s.toCharArray()) {
            charFrequencies.put(c, charFrequencies.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue()
        );
        maxHeap.addAll(charFrequencies.entrySet());

        StringBuilder sortedString = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                sortedString.append(entry.getKey());
            }
        }
        return sortedString.toString();
    }

    public static void main(String[] args) {
        String input = "tree";
        String sortedString = frequencySort(input);
        System.out.println("Sorted string: " + sortedString); // Output: eetr
    }
}
        */

    }
}