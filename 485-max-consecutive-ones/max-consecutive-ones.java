class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0,count = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                count++;
            }
            if(count > max)
                max = count;

            if(nums[i] == 0){
                count=0;
            } 
             
        }

        return max;
    }
}