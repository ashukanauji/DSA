class Solution {
    public int maximumLength(int[] nums, int k) {

        int n = nums.length;
        if (k == 1) 
            return n;
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) 
            arr[i] = nums[i] % k;
        
        int ans = 2;
        for (int i = 0; i < k; i++) {
            int[] dp = new int[k];
            for (int j = 0; j < n; j++) {
                int x = arr[j];
                int y = i - x;
                if(y < 0) y += k;

                dp[x] = dp[y] + 1;
                ans = Math.max(ans, dp[x]);
            }
        }

        return ans;
    }
}