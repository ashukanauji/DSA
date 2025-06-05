class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;

        while(j < nums.length){
            if(nums[i] != 0){
                i++;
                j++;
            }
            else if(nums[j] == 0)
                j++;

            else{
                nums[i] = nums[j];
                nums[j] = 0;
            }
        }
    }
}