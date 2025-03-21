class Solution {
    public void moveZeroes(int[] nums) {
        int temp = 0;
        for(int i=0; i<nums.length; i++){
            if(temp<=i && nums[temp] == 0 && nums[i] == 0){
                continue;
            }

            else{
                int temp1 = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp1;
                temp++;  
            }
               
        }
    }
}