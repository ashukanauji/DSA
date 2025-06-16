class Solution {
    public int maximumDifference(int[] nums) {
        int mini = nums[0], diff = -1;
        int maxi = 0;
        int i=0;
        while(i<nums.length)
        {
            if(nums[i]-mini>0)
            {
                diff=Math.max(diff,nums[i]-mini);
            }
            if(nums[i]<mini)
            {
                mini=nums[i];
            }
            i++;
            // System.out.println(diff);
        }
        return diff;
        
    }
}