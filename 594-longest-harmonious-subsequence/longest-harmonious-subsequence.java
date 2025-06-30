class Solution {
    public int findLHS(int[] nums) {
        int i = 0, j = 1;
        int len = 0, temp = 0;

        Arrays.sort(nums);
        while(i < j && j < nums.length){
            if(nums[i] == nums[j]){
                j++;
                continue;
            }
            int max = Math.max(nums[i],nums[j]);
            int min = Math.min(nums[i],nums[j]);
            if(max - min == 1){
                temp = j-i+1;
                j++;
            }
            else{
                i++;
                if(i == j)
                    j++;
            }
            if(temp >= len)
                len = temp;

        }

        return len;
    }
}