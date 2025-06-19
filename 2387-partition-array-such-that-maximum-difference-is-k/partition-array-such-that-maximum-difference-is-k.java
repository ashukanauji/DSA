class Solution {
    public int partitionArray(int[] nums, int k) {
        // int count = 0;
        // int max = Integer.MIN_VALUE;
        // int min = Integer.MAX_VALUE;

        // List<List<Integer>> list = new ArrayList<>();

        // for(int i = 0; i < nums.length; i++){
        //     max = Math.max(nums[i], max);
        //     min = Math.min(nums[i], min);

        //     if(list.isEmpty())
        //         list.add(Arrays.asList(nums[i]));

        //     else{



        //     }
        // }

        if(nums.length == 1)
            return 1;
        Arrays.sort(nums);

        

        int count = 1;
        int min = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(nums[i] - min <= k)
                continue;
            else{
                min = nums[i];
                count++;
            }
        }
        return count;
    }
}