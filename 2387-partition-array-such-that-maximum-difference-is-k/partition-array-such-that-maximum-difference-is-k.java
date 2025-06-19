class Solution {
    public int partitionArray(int[] nums, int k) {
        if(nums.length == 1)
            return 1;

        Arrays.sort(nums);

        int count = 1;
        int min = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(nums[i] - min > k){
                min = nums[i];
                count++;
            }
        }
        return count;
    }
}