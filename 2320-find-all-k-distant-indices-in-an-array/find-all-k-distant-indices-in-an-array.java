class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> list = new ArrayList<>();
        // int i = 0 , j = 1;
        int j;
        for(int i = 0; i < nums.length; i++){
            if(i-k < 0)
                j = 0;
            else
                j = i-k;
            while(j < nums.length && j <= i+k){
                if(nums[j] == key && Math.abs(j-i) <= k){
                    list.add(i);
                    break;
                }   
                j++;
            }
        }

        Collections.sort(list);

        return list;

    }
}