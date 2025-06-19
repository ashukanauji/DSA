class Solution {
    public int maxFrequency(int[] nums, int k) {
        
        // if(nums.length == 1)
        //     return 1;

        // Arrays.sort(nums);

        // int freq = 0;

        // int i = 0, j = 1;

        // while(j < nums.length && i <= j){
        //     int temp = k;
        //     long sum = nums[i];
        //     int windowLength = 0;
        //     while(temp >= 0 && j < nums.length){
        //         sum += nums[j];
        //         windowLength = j-i+1;
        //         long extra = windowLength*nums[j] - sum ;
        //         if(extra <= k){
        //             sum += extra;
        //             freq = Math.max(freq,windowLength);
        //             temp -= extra;
        //             j++;
        //         }
        //         else
        //             break;
        //     }
        //     i++;
        //     j = i+1;
        // }

        // if(freq == 0){
        //     return 1;
        // }
        // return freq;


        Arrays.sort(nums);
        int left = 0;
        long total = 0;
        int maxFreq = 0;

        for (int right = 0; right < nums.length; right++) {
            total += nums[right];

            // Total needed to make all nums[left...right] = nums[right]
            while ((long)(right - left + 1) * nums[right] - total > k) {
                total -= nums[left];
                left++;
            }

            maxFreq = Math.max(maxFreq, right - left + 1);
        }

        return maxFreq;
    }
}