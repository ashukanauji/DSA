class Solution {
    public int singleNumber(int[] nums) {
        int output = 0;

        for(int element: nums){
            output = output^element;
        }
        return output;
    }
}