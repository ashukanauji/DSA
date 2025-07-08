class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        int n = events.length;

        // Precompute next valid indices
        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            next[i] = binarySearch(events, i + 1, n, events[i][1]);
        }

        int[][] dp = new int[n + 1][k + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = k - 1; j >= 0; j--) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[next[i]][j + 1] + events[i][2]);
            }
        }

        return dp[0][0];
    }

    private static int binarySearch(int[][] events, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (events[mid][0] > target)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
}
