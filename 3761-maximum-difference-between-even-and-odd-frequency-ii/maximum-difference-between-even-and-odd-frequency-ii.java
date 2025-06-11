class Solution {
    private int[][] pre;

    // even or odd
    private int parity(int num) {
        return num & 1;
    }

    private int max_subarray_sum(int a, int b, String s, int k) {
        int n = s.length();
        int l = 0, r = k - 1;

        int r_freq_a = 0, r_freq_b = 0;
        int l_freq_a = 0, l_freq_b = 0;

        int sum = Integer.MIN_VALUE;
        // mat denotes second part, we have to minimize it
        final int INF = 100000000;
        int[][] mat = {{INF, INF}, {INF, INF}};

        while (r < n) {
            // update right-side prefix counts
            r_freq_a = pre[a][r + 1];
            r_freq_b = pre[b][r + 1];

            // can we move window from left
            while (r - l + 1 >= k && (r_freq_b - l_freq_b) >= 2) {
                // update current minimum
                mat[parity(l_freq_a)][parity(l_freq_b)] =
                    Math.min(mat[parity(l_freq_a)][parity(l_freq_b)], l_freq_a - l_freq_b);

                // move towards next window
                l_freq_a = pre[a][l + 1];
                l_freq_b = pre[b][l + 1];
                l++;
            }

            // calculate current subarray sum
            int calc = (r_freq_a - r_freq_b) - mat[parity(r_freq_a) ^ 1][parity(r_freq_b)];
            sum = Math.max(calc, sum);

            r++;
        }

        return sum;
    }

    public int maxDifference(String s, int k) {
        int n = s.length();
        // resizing the vector to n+1 length and 5 size i.e. 0,1,2,3,4
        pre = new int[5][n + 1];

        for (int i = 0; i < n; i++) {
            /// move all frequencies to current index
            for (int j = 0; j <= 4; j++) {
                pre[j][i + 1] = pre[j][i];
            }

            int conv = s.charAt(i) - '0';
            pre[conv][i + 1]++;
        }

        int diff = Integer.MIN_VALUE;

        // going from all possible pairs
        for (int i = 0; i <= 4; i++) {
            if (pre[i][n] == 0) continue;

            for (int j = 0; j <= 4; j++) {
                if (i == j || pre[j][n] == 0) continue;

                int calc = max_subarray_sum(i, j, s, k);
                diff = Math.max(diff, calc);
            }
        }

        return diff;
    }
}