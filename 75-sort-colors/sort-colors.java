class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = 0;

        for(int i=0; i<nums.length;i++){
            if(nums[i] == 0)
                zero++;
            else if(nums[i] == 1)
                one++;
            else
                two++;
        }
        int i=0;
        while((zero!=0 || one!=0 || two!=0) && i<nums.length){
            if(zero!=0){
                nums[i] = 0;
                i++;
                zero--;
                continue;
            }
            if(one!=0){
                nums[i] = 1;
                i++;
                one--;
                continue;
            }
            if(two!=0){
                nums[i] = 2;
                i++;
                two--;
                continue;
            }
        }
        return;
    }
}