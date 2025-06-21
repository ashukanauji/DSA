class Solution {
    public int minimumDeletions(String word, int k) {
        int[] frequency = new int[26];
        for (char c : word.toCharArray()) {
            frequency[c - 'a']++;
        }
        int minDeletions = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (frequency[i] == 0) continue;
            int deletions = 0;
            for (int j = 0; j < 26; j++) {
                if (i == j || frequency[j] == 0) continue;
                if (frequency[j] < frequency[i]) deletions += frequency[j];
                else if (frequency[j] - frequency[i] > k) {
                    deletions += frequency[j] - frequency[i] - k;
                }
            }
            minDeletions = Math.min(minDeletions, deletions);
        }
        return minDeletions;
    }
}